package com.hackathon.initscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hackathon.initscreen.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailSendBtn.setOnClickListener {
            //인증번호 전송
            Toast.makeText(this@CheckActivity,"인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show()
       }

        binding.checkBtn.setOnClickListener {
            //인증되면 로그인 화면으로
                val intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)
        }
    }
}