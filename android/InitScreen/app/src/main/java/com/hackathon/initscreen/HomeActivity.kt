package com.hackathon.initscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCau.setOnClickListener {
            val cintent = Intent(this, CauActivity::class.java)
            startActivity(cintent)
        }

        binding.btnSmw.setOnClickListener {
            val mintent = Intent(this, SmwActivity::class.java)
            startActivity(mintent)
        }

        binding.btnSkku.setOnClickListener {
            val sintent = Intent(this, SkkuActivity::class.java)
            startActivity(sintent)
        }
    }
}