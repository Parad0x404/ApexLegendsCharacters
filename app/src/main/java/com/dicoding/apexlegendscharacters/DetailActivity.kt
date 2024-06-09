package com.dicoding.apexlegendscharacters

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        var EXTRA_LEGEND = "extra_legend"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Apex Legends"

        val dataLegend = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Legend>(EXTRA_LEGEND, Legend::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Legend>(EXTRA_LEGEND)
        }

        val imgPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_data_name)
        val tvRealName: TextView = findViewById(R.id.tv_data_realname)
        val tvAge: TextView = findViewById(R.id.tv_data_age)
        val tvHomeWorld: TextView = findViewById(R.id.tv_data_planet)
        val tvTitle: TextView = findViewById(R.id.tv_data_title)
        val tvDescription: TextView = findViewById(R.id.tv_data_description)

        if (dataLegend != null) {
            tvName.text = dataLegend.name
            tvTitle.text = dataLegend.title
            tvDescription.text = dataLegend.description
            tvRealName.text = dataLegend.realName
            tvAge.text = dataLegend.age
            tvHomeWorld.text = dataLegend.homeWorld
            dataLegend.photo.let { imageUrl ->
                Glide.with(this)
                    .load(imageUrl)
                    .into(imgPhoto)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_share -> {

                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "This is my text about apex legends.")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}