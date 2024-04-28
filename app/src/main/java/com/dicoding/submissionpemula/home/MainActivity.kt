package com.dicoding.submissionpemula.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submissionpemula.R
import com.dicoding.submissionpemula.about.AboutActivity
import com.dicoding.submissionpemula.detail.DetailActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rvFruits: RecyclerView
    private val list = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruits = findViewById(R.id.rv_fruits)
        rvFruits.setHasFixedSize(true)

        list.addAll(getListFruits())
        showRecyclerlist()
    }

    private fun getListFruits(): ArrayList<Fruit> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFruit.add(fruit)
        }
        return listFruit
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerlist() {
        rvFruits.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruits.adapter = listFruitAdapter


        listFruitAdapter.setOnItemClickCallback(object : ListFruitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fruit) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(fruit: Fruit) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_FRUIT, fruit)
        startActivity(intent)
    }
}
