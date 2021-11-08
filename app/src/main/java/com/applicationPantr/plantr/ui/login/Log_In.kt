package com.applicationPantr.plantr.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.applicationPantr.plantr.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.*

class Log_In : Fragment(R.layout.fragment_log_in) {
    private val mAuth = FirebaseAuth.getInstance()
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skipAction()
        ivLogin.setOnClickListener {

        loginUserAccount()
    }
    }
    ///
    private fun skipAction() {
        tvLoginSkip.setOnClickListener {
            val notificationIntent = Intent(activity, ready::class.java)
            startActivity(notificationIntent)
        }
    }
    private fun loginUserAccount() {

        val email = etEmailLogIn.text.toString()
        val password = etPasswordLogIn.text.toString()



        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Login successful!!" + mAuth.currentUser!!.email, Toast.LENGTH_LONG).show()
                    val notificationIntent = Intent(activity, ready::class.java)
                    startActivity(notificationIntent)

                } else {

                    Toast.makeText(context, "inValid Credentials ", Toast.LENGTH_LONG).show()

                }
            }
    }
}

