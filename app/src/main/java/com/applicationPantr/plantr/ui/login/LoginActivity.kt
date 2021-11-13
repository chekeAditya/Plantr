package com.applicationPantr.plantr.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.applicationPantr.plantr.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import android.content.Intent
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_log_in.*

@AndroidEntryPoint
open class LoginActivity : AppCompatActivity() {
private lateinit var mAuth :FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth= FirebaseAuth.getInstance()
        val  user =mAuth.currentUser
        SwitchTab()
        facebookAuthentication()
        googleAuthentication()
        tab_login.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.BNWBlack));

    }

    private fun SwitchTab() {
        val viewpagerLogin: ViewPager = findViewById(R.id.viewPager)
        val tablayoutLog_In: TabLayout = findViewById(R.id.tab_login)
        val logInAdapter = LogInAdapter(supportFragmentManager)
        logInAdapter.addFragment(Sign_In(), "Sign-In")
        logInAdapter.addFragment(Log_In(), "Log-In")
        viewpagerLogin.adapter = logInAdapter
        tablayoutLog_In.setupWithViewPager(viewPager)



        tablayoutLog_In.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        tvWelcomeBack.isVisible = false
                        tvWelcomeTwo2.isVisible = false
                        tvOrTwo.isVisible=false
                        tvWelcome.isVisible = true
                        tvWelcomeTwo.isVisible = true
                        tvOr.isVisible = true
                    }
                    1 -> {
                        if (tab.position == 1)
                            tvWelcomeBack.isVisible = true
                        tvWelcomeTwo2.isVisible = true
                        tvOrTwo.isVisible=true
                        tvWelcome.isVisible = false
                        tvWelcomeTwo.isVisible = false
                        tvOr.isVisible = false
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun facebookAuthentication() {

        ivFacebook.setOnClickListener {
            val notificationIntent = Intent(this, faceookAuth::class.java)
            startActivity(notificationIntent)
        }
    }
    private fun googleAuthentication(){
        ivGoogle.setOnClickListener {
            val notificationIntentGoogle = Intent(this, googleAuth::class.java)
            startActivity(notificationIntentGoogle)
        }
    }

}


