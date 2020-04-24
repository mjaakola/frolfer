package com.example.frolfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Frontpage_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frontpage)

        configureCustomGameButton()

    }

    private fun configureCustomGameButton() {
        val CustomGameButton = findViewById<Button>(R.id.customGameButton)
        CustomGameButton.setOnClickListener{
            val intent = Intent(this, NumberOfHolesActivity::class.java)
            startActivity(intent)
        }
    }

}
