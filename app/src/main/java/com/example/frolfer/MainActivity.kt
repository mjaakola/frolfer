package com.example.frolfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    internal var score: Int = 0
    internal var hole: Int = 1
    internal var total_holes: Int = 0
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
        setContentView(R.layout.activity_main)

        //initialize variables
        hole_number = findViewById(R.id.hole_number)
        hole_number.text = getString(R.string.current_hole, hole)
        current_score = findViewById(R.id.current_score)
        current_score.text = getString(R.string.yourScore, score)
        val totalHoles = intent.getIntExtra("TOTAL_HOLES", 0 )
        total_holes = totalHoles
        val scoreList = generateList(size = totalHoles + 1)                             // adapt for # of holes + 1
        recyclerView9Hole.adapter = ExampleAdapter(scoreList)
        recyclerView9Hole.layoutManager = LinearLayoutManager(this)
        recyclerView9Hole.setHasFixedSize(true)

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

    private fun nextHole() {
        if (hole < total_holes) {
            hole += 1
            val newHole = getString(R.string.current_hole, hole)
            hole_number.text = newHole
            score = 0
            current_score.text = getString(R.string.yourScore, score)
        }
    }

    private fun previousHole() {
        if (hole > 1) {
            hole -= 1
            val newHole = getString(R.string.current_hole, hole)
            hole_number.text = newHole
            score = 0
            current_score.text = getString(R.string.yourScore, score)
        }
    }

    // RecyclerView
    private fun generateList(size: Int): List<RecyclerViewItem> {
        val list = ArrayList<RecyclerViewItem>()
            for (i in 0+1 until size) {
                val holei = RecyclerViewItem("Hole $i", "@string/Attempt", "@string/par3Warning")
                list += holei
            }
            return list
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
