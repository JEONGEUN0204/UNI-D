package com.hackathon.initscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_find.*

class FindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        id_find_btn.setOnClickListener {
            Toast.makeText(this@FindActivity,"ID가 전송되었습니다.",Toast.LENGTH_SHORT).show()
        }
        pw_find_btn.setOnClickListener {
            Toast.makeText(this@FindActivity,"PW가 전송되었습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}