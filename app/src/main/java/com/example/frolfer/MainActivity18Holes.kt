package com.example.frolfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity18Holes : AppCompatActivity() {

    internal var score: Int = 0
    internal var hole: Int = 1
    private val totalHoles = 18
    internal lateinit var addition: Button
    internal lateinit var minus: Button
    internal lateinit var currentScore: TextView
    internal lateinit var holeNumber: TextView


    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val SCORE_KEY = "SCORE_KEY"
        private const val CURRENT_HOLE = "CURRENT_HOLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity18_holes)

        Log.d(TAG, "onCreate called. Score is: $score")

        currentScore = findViewById(R.id.current_score)
        currentScore.text = getString(R.string.yourScore, score)
        holeNumber = findViewById(R.id.hole_number)
        holeNumber.text = getString(R.string.current_hole, hole, totalHoles )
        val addition = findViewById<Button>(R.id.addition)
        val minus = findViewById<Button>(R.id.minus)
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
        currentScore.text = newScore
    }

    private fun decreaseScore() {
        score -= 1
        val newScore = getString(R.string.yourScore, score)
        currentScore.text = newScore
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
