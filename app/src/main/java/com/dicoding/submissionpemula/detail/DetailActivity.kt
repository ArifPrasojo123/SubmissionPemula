package com.dicoding.submissionpemula.detail

import android.app.Person
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.submissionpemula.R
import com.dicoding.submissionpemula.home.Fruit

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fruit = intent.getParcelableExtra<Fruit>(EXTRA_FRUIT)
        fruit?.let {
            showFruitDetail(it)
        }

    }

    private fun showFruitDetail(fruit: Fruit) {
        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvItemDescription: TextView = findViewById(R.id.tv_item_description)

        imgDetailPhoto.setImageResource(fruit.photo)
        tvDetailName.text = fruit.name
        tvItemDescription.text = fruit.description
    }
}
