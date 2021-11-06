package com.hackathon.initscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        gocheck_btn.setOnClickListener {
            val intent=Intent(this,CheckActivity::class.java)
            startActivity(intent)
        }
    }
}