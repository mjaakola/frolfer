package com.example.frolfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Frontpage_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frontpage)

        configureNineHoleButton()
        configureEighteenHoleButton()

    }

    private fun configureNineHoleButton() {
        val nineHoleButton = findViewById<Button>(R.id.NineHoleButton)
        nineHoleButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configureEighteenHoleButton() {
        val EighteenHoleButton = findViewById<Button>(R.id.EighteenHoleButton)
        EighteenHoleButton.setOnClickListener{
            val intent = Intent(this, MainActivity18Holes::class.java)
            startActivity(intent)
        }
    }
}
