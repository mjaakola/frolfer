package com.example.frolfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_of_holes.*

class NumberOfHolesActivity : AppCompatActivity() {             //, View.OnClickListener
    companion object {
        private val TAG = NumberOfHolesActivity::class.java.simpleName
    }

    lateinit var totalHoles: EditText           //initialize later
    lateinit var createScorecardButton: Button
    lateinit var string: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_of_holes)

        totalHoles = findViewById(R.id.editText)
        createScorecardButton = findViewById(R.id.createScorecardButton)

        configureCreateScorecardButton()
/*
        editText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                var totalHoles = v.text.toString()                // creates a string once Done button clicked
                Toast.makeText(this, totalHoles, Toast.LENGTH_SHORT).show();
                return@OnEditorActionListener true
            }
            false
        })
*/
        Log.d(TAG, "User enterred number of holes: $totalHoles")

        //back button on actionbar
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun configureCreateScorecardButton() {
        createScorecardButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
                val string = totalHoles.text.toString().toInt()
                intent.putExtra("TOTAL_HOLES", string)
                startActivity(intent)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}



