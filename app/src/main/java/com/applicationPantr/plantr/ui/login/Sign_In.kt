package com.applicationPantr.plantr.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.*


class Sign_In : Fragment(R.layout.fragment_sign_in) {
    private var mAuth = FirebaseAuth.getInstance()

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
            }

    }

}