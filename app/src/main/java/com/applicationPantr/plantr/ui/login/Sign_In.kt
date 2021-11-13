package com.applicationPantr.plantr.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.chat._chat.UserActivity
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_sign_in.*


class Sign_In : Fragment(R.layout.fragment_sign_in) {
    private var mAuth = FirebaseAuth.getInstance()
    private lateinit var databaseReference: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skipActionSignUp()
        ivSignIn.setOnClickListener {
            registerNewUser()
        }
    }

    private fun skipActionSignUp() {
        tvSignupSkip.setOnClickListener {
            val notificationIntent = Intent(activity, HomeActivity::class.java)
            startActivity(notificationIntent)
        }
    }

    private fun registerNewUser() {
        val name = etNameSignIn.text.toString()
        val email = etEmailSignIn.text.toString()
        val password = etPasswordSignIn.text.toString()

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Please enter Name!!", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user: FirebaseUser? = mAuth.currentUser
                    val userId: String = user!!.uid

                    databaseReference = FirebaseDatabase.getInstance().getReference("Users")
                        .child(userId)
                    val hashMap: HashMap<String, String> = HashMap()

                    hashMap.put("userId", userId)
                    hashMap.put("userName", name)
                    hashMap.put("profileImage", "")
                    databaseReference.setValue(hashMap).addOnCompleteListener { it ->
                        if (it.isSuccessful) {
                            //open home activity
                            etNameSignIn.setText("")
                            etEmailSignIn.setText("")
                            etPasswordSignIn.setText("")
                            var intent = Intent(context, HomeActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(
                                context,
                                "Successfully login",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }
    }

    /*
    if (it.isSuccessful){
            Toast.makeText(
                context,
                "Registration successful!" + mAuth.currentUser!!.displayName,
                Toast.LENGTH_LONG
            ).show()
            val notificationIntent = Intent(context, HomeActivity::class.java)
            startActivity(notificationIntent)

        } else {

            Toast.makeText(
                context,
                "Registration failed!!" + "inValid Credentials",
                Toast.LENGTH_LONG
            ).show()

        }
    */
}