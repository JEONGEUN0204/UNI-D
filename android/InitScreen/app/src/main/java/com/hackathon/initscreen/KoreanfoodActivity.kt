package com.hackathon.initscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivityKoreanfoodBinding

class KoreanfoodActivity: AppCompatActivity() {
    private lateinit var binding: ActivityKoreanfoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoreanfoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}