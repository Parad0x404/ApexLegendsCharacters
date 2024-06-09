package com.dicoding.apexlegendscharacters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLegends: RecyclerView
    private val list = ArrayList<Legend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLegends = findViewById(R.id.rv_apexlegends)
        rvLegends.setHasFixedSize(true)

        list.addAll(getlistLegends())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        this.startActivity(moveIntent)

        return super.onOptionsItemSelected(item)
    }

    private fun showRecycleList() {
        rvLegends.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListLegendAdapter(list)
        rvLegends.adapter = listHeroAdapter
    }

    private fun getlistLegends(): Collection<Legend> {
        val dataName = resources.getStringArray(R.array.legends_name)
        val dataTitle = resources.getStringArray(R.array.legends_title)
        val dataDescription = resources.getStringArray(R.array.legends_description)
        val dataPhoto = resources.getStringArray(R.array.legends_photo)
        val realName = resources.getStringArray(R.array.legends_realName)
        val age = resources.getStringArray(R.array.legends_age)
        val homeWorld = resources.getStringArray(R.array.legends_homePlanet)

        val listLegend = ArrayList<Legend>()
        for (i in dataName.indices) {
            val legend = Legend(dataName[i], dataTitle[i], dataDescription[i], dataPhoto[i], realName[i], age[i], homeWorld[i])
            listLegend.add(legend)
        }
        return listLegend
    }
}