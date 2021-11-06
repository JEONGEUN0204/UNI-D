package com.hackathon.initscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivityCauBinding

class CauActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCauBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCauBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}