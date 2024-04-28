package com.dicoding.submissionpemula.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.submissionpemula.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgProfile: ImageView = findViewById(R.id.img_profile)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvEmail: TextView = findViewById(R.id.tv_email)

        imgProfile.setImageResource(R.drawable.arif)
        tvName.text = "Muhammad Arif Prasojo"
        tvEmail.text = "a288d4ky3718@bangkit.academy"
    }
}
