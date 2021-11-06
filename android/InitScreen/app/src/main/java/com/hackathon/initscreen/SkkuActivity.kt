package com.hackathon.initscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivitySkkuBinding

class SkkuActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySkkuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkkuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}