package com.hackathon.initscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivitySmwBinding

class SmwActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySmwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKoreanfood.setOnClickListener {
            val intent = Intent(this,KoreanfoodActivity::class.java)
            startActivity(intent)
        }
    }
}