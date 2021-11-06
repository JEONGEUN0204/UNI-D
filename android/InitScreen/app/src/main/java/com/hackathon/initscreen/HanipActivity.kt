package com.hackathon.initscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivityHanipBinding

class HanipActivity:AppCompatActivity() {
    private lateinit var binding: ActivityHanipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHanipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCommentWrite.setOnClickListener {
            val writeintent = Intent(this, CommentWriteActivity::class.java)
            startActivity(writeintent)
        }
        binding.ivDetailBack.setOnClickListener {
            val detailinent = Intent(this, KoreanfoodActivity::class.java)
            startActivity(detailinent)
        }
    }
}