package com.hackathon.initscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.initscreen.databinding.ActivityKoreanfoodBinding

class KoreanfoodActivity: AppCompatActivity() {
    private lateinit var binding: ActivityKoreanfoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoreanfoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivDetailBack.setOnClickListener {
            val detailinent = Intent(this, SmwActivity::class.java)
            startActivity(detailinent)
        }
        binding.tvHanipDetail.setOnClickListener {
            val inent = Intent(this, HanipActivity::class.java)
            startActivity(inent)
        }
        binding.tvThehamDetail.setOnClickListener {
            val inent = Intent(this, ThehamActivity::class.java)
            startActivity(inent)
        }
        binding.tvSsangDetail.setOnClickListener {
            val inent = Intent(this, SsangActivity::class.java)
            startActivity(inent)
        }
        binding.tvSookDetail.setOnClickListener {
            val inent = Intent(this, SookActivity::class.java)
            startActivity(inent)
        }
        binding.tvMihoDetail.setOnClickListener {
            val inent = Intent(this, MihoActivity::class.java)
            startActivity(inent)
        }

        binding.ivHanipDetail.setOnClickListener {
            val inent = Intent(this, HanipActivity::class.java)
            startActivity(inent)
        }
        binding.ivThehamDetail.setOnClickListener {
            val inent = Intent(this, ThehamActivity::class.java)
            startActivity(inent)
        }
        binding.ivSsangDetail.setOnClickListener {
            val inent = Intent(this, SsangActivity::class.java)
            startActivity(inent)
        }
        binding.ivSookDetail.setOnClickListener {
            val inent = Intent(this, SookActivity::class.java)
            startActivity(inent)
        }
        binding.ivMihoDetail.setOnClickListener {
            val inent = Intent(this, MihoActivity::class.java)
            startActivity(inent)
        }
    }

}
