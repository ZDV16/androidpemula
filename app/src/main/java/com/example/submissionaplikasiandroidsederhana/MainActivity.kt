package com.example.submissionaplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var poto: ImageView
    private lateinit var rvPlayers: RecyclerView
    private val list = ArrayList<Players>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()

        poto = findViewById(R.id.about_page)

        poto.setOnClickListener(this)

    }

    private fun getListHeroes(): ArrayList<Players> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataBirth = resources.getStringArray(R.array.data_birth)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPlayers = ArrayList<Players>()
        for (i in dataName.indices) {
            val player = Players(dataName[i], dataDescription[i],dataPosition[i],dataBirth[i], dataPhoto.getResourceId(i, -1))
            listPlayers.add(player)
        }
        return listPlayers
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayersAdapter = ListPlayerAdapter(list)
        rvPlayers.adapter = listPlayersAdapter
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.about_page -> {
                val aboutPage = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutPage)
            }

        }
    }
}