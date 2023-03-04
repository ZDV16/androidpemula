package com.example.submissionaplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class PlayerDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: ImageButton
    private lateinit var share: Button
    companion object {
        const val KEY_PLAYER = "key_player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        back = findViewById(R.id.btn_back)
       back.setOnClickListener(this)
        share = findViewById(R.id.btn_share)
        share.setOnClickListener(this)

        val dataPlayer = intent.getParcelableExtra("key_player") as Players?

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvPosition = findViewById<TextView>(R.id.tv_position)
        val tvBirthdate = findViewById<TextView>(R.id.tv_birthdate)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_player)


        tvDetailName.text = dataPlayer?.name
        tvPosition.text = dataPlayer?.position
        tvBirthdate.text = dataPlayer?.birth
        tvDetailDescription.text = dataPlayer?.description

        if (dataPlayer != null) {
            ivDetailPhoto.setImageResource(dataPlayer.photo)
        }


    }

    override fun onClick(v: View) {
            when(v.id){
            R.id.btn_back -> {
                val mainPage = Intent(this@PlayerDetailActivity, MainActivity::class.java)
                startActivity(mainPage)

            }
            R.id.btn_share -> {
                val dataPlayer = intent.getParcelableExtra("key_player") as Players?
                val namapemain = dataPlayer?.name
                val posisipemain = dataPlayer?.position
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Hey, kamu harus liat $namapemain, dia keren banget! Dia berposisi sebagai $posisipemain yang bermain di Manchester United!")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)


            }
            }

    }


}

