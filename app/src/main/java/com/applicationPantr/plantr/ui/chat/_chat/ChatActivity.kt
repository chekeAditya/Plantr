package com.applicationPantr.plantr.ui.chat._chat

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters._ChatAdapter
import com.applicationPantr.plantr.remote.response.chatresponse.Chat
import com.applicationPantr.plantr.remote.response.chatresponse.NotificationDataModel
import com.applicationPantr.plantr.remote.response.chatresponse.PushNotification
import com.applicationPantr.plantr.remote.response.chatresponse.User
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_user.*
import java.io.Serializable
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap


class ChatActivity : AppCompatActivity(), Serializable {

    var firebaseUser: FirebaseUser? = null
    var reference: DatabaseReference? = null
    var chatList = ArrayList<Chat>()
    var topic = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        showAlertBox()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        chatRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var intent = getIntent()
        var userId = intent.getStringExtra("userId")
        var userName = intent.getStringExtra("userName")


        firebaseUser = FirebaseAuth.getInstance().currentUser
        reference = FirebaseDatabase.getInstance().getReference("Users").child(userId!!)

        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val user = snapshot.getValue(User::class.java)
                tvUserName.text = user!!.userName
//                if (user.profileImage == "") {
//                    imgProfile.setImageResource(R.drawable.bg_img)
//                } else {
//                    Glide.with(this@ChatActivity).load(user.profileImage).into(imgProfile)
//                }
            }
        })

        btnSendMessage.setOnClickListener {
            var message: String = etMessage.text.toString()

            if (message.isEmpty()) {
                Toast.makeText(applicationContext, "message is empty", Toast.LENGTH_SHORT).show()
                etMessage.setText("")
            } else {
                sendMessage(firebaseUser!!.uid, userId, message)
                etMessage.setText("")
                topic = "/topics/$userId"
                PushNotification(
                    NotificationDataModel(userName!!, message),
                    topic
                ).also {
//                    sendNotification(it)
                }
            }
        }
        readMessage(firebaseUser!!.uid, userId)
    }

    private fun sendMessage(senderId: String, receiverId: String, message: String) {
        var reference: DatabaseReference? = FirebaseDatabase.getInstance().getReference()

        var hashMap: HashMap<String, String> = HashMap()
        hashMap.put("senderId", senderId)
        hashMap.put("receiverId", receiverId)
        hashMap.put("message", message)

        reference!!.child("Chat").push().setValue(hashMap)

    }

    fun readMessage(senderId: String, receiverId: String) {
        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Chat")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                chatList.clear()
                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val chat = dataSnapShot.getValue(Chat::class.java)

                    if (chat!!.senderId.equals(senderId) && chat!!.receiverId.equals(receiverId) ||
                        chat!!.senderId.equals(receiverId) && chat!!.receiverId.equals(senderId)
                    ) {
                        chatList.add(chat)
                    }
                }

                val chatAdapter = _ChatAdapter(this@ChatActivity, chatList)

                chatRecyclerView.adapter = chatAdapter
            }
        })
    }

//    private fun sendNotification(notification: PushNotification) =
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = RetrofitInstance.api.postNotification(notification)
//                if (response.isSuccessful) {
//                    Log.d("TAG", "Response: ${Gson().toJson(response)}")
//                } else {
//                    Log.e("TAG", response.errorBody()!!.string())
//                }
//            } catch (e: Exception) {
//                Log.e("TAG", e.toString())
//            }
//        }

    private fun showAlertBox() {
        val builder = AlertDialog.Builder(this)
        val layoutInflaterAndroid = LayoutInflater.from(this)
        val view: View = layoutInflaterAndroid.inflate(R.layout.item_alert_box_start, null)
        builder.setView(view)
        builder.setCancelable(false)
        val alertDialog = builder.create()

        alertDialog.show()
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.window!!.setGravity(Gravity.BOTTOM)
        view.findViewById<View>(R.id.btnStart).setOnClickListener { v: View? ->
            startTimer()
            alertDialog.dismiss()
        }
        view.findViewById<View>(R.id.btnExit)
            .setOnClickListener { v: View? -> alertDialog.dismiss() }
    }

    private fun startTimer() {
        val duration = TimeUnit.MINUTES.toMillis(1)
        object : CountDownTimer(duration, 1000) {
            override fun onTick(l: Long) {
                val sDuration = String.format(
                    Locale.ENGLISH, "%02d : %02d",
                    TimeUnit.MILLISECONDS.toMinutes(l),
                    TimeUnit.MILLISECONDS.toSeconds(l) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))
                )
                tvTimer.text = sDuration
            }

            override fun onFinish() {
                tvTimer.visibility = View.GONE
                showEndDialogBox()
            }
        }.start()
    }

    private fun showEndDialogBox() {
        val builder = AlertDialog.Builder(this)
        val layoutInflaterAndroid = LayoutInflater.from(this)
        val view: View = layoutInflaterAndroid.inflate(R.layout.item_alert_box_end, null)
        builder.setView(view)
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.window!!.setGravity(Gravity.BOTTOM)
        view.findViewById<View>(R.id.btnJoinPlans).setOnClickListener {
            //go to getPlans Ad      
        }
        view.findViewById<View>(R.id.btnExit)
            .setOnClickListener {
                val intent = Intent(this@ChatActivity, HomeActivity::class.java)
                startActivity(intent)
            }
    }
}