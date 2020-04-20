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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    internal var golfScore = mutableListOf<Int>(0)
    internal val stringList = listOf<String>("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9")
    internal var score: Int = 0
    internal var hole: Int = 1
    internal val total_holes = 9
    internal var par = 3
    internal lateinit var addition: Button
    internal lateinit var minus: Button
    internal lateinit var current_score: TextView
    internal lateinit var hole_number: TextView
    internal lateinit var hole_score: TextView


    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val SCORE_KEY = "SCORE_KEY"
        private const val CURRENT_HOLE = "CURRENT_HOLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize score, current hole
        hole_number = findViewById(R.id.hole_number)
        hole_number.text = getString(R.string.current_hole, hole, total_holes)
        current_score = findViewById(R.id.current_score)
        current_score.text = getString(R.string.yourScore, score)
        hole_score = findViewById(R.id.hole1)
        hole_score.text = getString(R.string.h1, golfScore[0])

        //initialize buttons
        val addition = findViewById(R.id.addition) as Button
        val minus = findViewById(R.id.minus) as Button
        val nextHoleButton = findViewById<Button>(R.id.nextHoleButton)
        val previousHoleButton = findViewById<Button>(R.id.previousHoleButton)
        addition.setOnClickListener{
            incrementScore()
        }
        minus.setOnClickListener{
            decreaseScore()
        }
        nextHoleButton.setOnClickListener{
            nextHole()
        }
        previousHoleButton.setOnClickListener {
            previousHole()
        }

        //back button on actionbar
        val actionbar = supportActionBar
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
        if (score > 1) {
            score -= 1
            val newScore = getString(R.string.yourScore, score)
            current_score.text = newScore
        }
    }
    /*
    private fun nextHole() {
        for (i in stringList) {
            if (hole < 9) {
                hole += 1
                val newHole = getString(R.string.current_hole, hole, total_holes)
                hole_number.text = newHole
                golfScore.add(index = (hole-2), element = score - par)
                Log.d(TAG, "golfScore: " + golfScore)
                hole_score.text = getString(R.id.stringList[i], golfScore[0])
                score = 0
                current_score.text = getString(R.string.yourScore, score)
            }
        }
    }
*/

    private fun nextHole() {
        if (hole < 9) {
            hole += 1
            val newHole = getString(R.string.current_hole, hole, total_holes)
            hole_number.text = newHole
            golfScore.add(index = (hole-2), element = score - par)
            Log.d(TAG, "golfScore: " + golfScore)
            hole_score.text = getString(R.string.h1, golfScore[0])
            score = 0
            current_score.text = getString(R.string.yourScore, score)
            golfScore.joinToString()
        }
    }

    private fun previousHole() {
        if (hole > 1) {
            hole -= 1
            val newHole = getString(R.string.current_hole, hole, total_holes)
            hole_number.text = newHole
            score = 0
            current_score.text = getString(R.string.yourScore, score)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
