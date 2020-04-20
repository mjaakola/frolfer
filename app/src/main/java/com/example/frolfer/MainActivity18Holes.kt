package com.example.frolfer

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity18Holes : AppCompatActivity() {

    internal var score: Int = 0
    internal var hole: Int = 1
    val total_holes = 18
    internal lateinit var addition: Button
    internal lateinit var minus: Button
    internal lateinit var current_score: TextView
    internal lateinit var hole_number: TextView


    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val SCORE_KEY = "SCORE_KEY"
        private const val CURRENT_HOLE = "CURRENT_HOLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity18_holes)

        Log.d(TAG, "onCreate called. Score is: $score")

        current_score = findViewById(R.id.current_score)
        current_score.text = getString(R.string.yourScore, score)
        hole_number = findViewById(R.id.hole_number)
        hole_number.text = getString(R.string.current_hole, hole, total_holes )
        val addition = findViewById(R.id.addition) as Button
        val minus = findViewById(R.id.minus) as Button
        addition.setOnClickListener{
            incrementScore()
        }
        minus.setOnClickListener{
            decreaseScore()
        }

        //back button on actionbar
        val actionbar = supportActionBar
        //set actionbar title
        //actionbar!!.title = "New Activity"
        //set back button
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, score)
        outState.putInt(CURRENT_HOLE, hole)
        Log.d(TAG, "onSaveInstanceState: Saving Score: $score")
    }

    private fun incrementScore() {
        score += 1
        val newScore = getString(R.string.yourScore, score)
        current_score.text = newScore
    }

    private fun decreaseScore() {
        score -= 1
        val newScore = getString(R.string.yourScore, score)
        current_score.text = newScore
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
