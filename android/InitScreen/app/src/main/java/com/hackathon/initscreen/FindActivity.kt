package com.hackathon.initscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hackathon.initscreen.databinding.ActivityFindBinding


class FindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idFindBtn.setOnClickListener {
            Toast.makeText(this@FindActivity,"아이디가 전송되었습니다.",Toast.LENGTH_SHORT).show()
        }
        binding.pwFindBtn.setOnClickListener {
            Toast.makeText(this@FindActivity,"비밀번호가 전송되었습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}