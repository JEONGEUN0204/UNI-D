package com.hackathon.initscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivitySsangBinding

class SsangActivity:AppCompatActivity() {
    private lateinit var binding: ActivitySsangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySsangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCommentWrite.setOnClickListener {
            val writeintent = Intent(this, CommentWriteActivity::class.java)
            startActivity(writeintent)
        }
    }
}