package com.hackathon.initscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        join_btn.setOnClickListener {
            val intent=Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }
        find_btn.setOnClickListener {
            val intent=Intent(this,FindActivity::class.java)
            startActivity(intent)
        }
    }
}