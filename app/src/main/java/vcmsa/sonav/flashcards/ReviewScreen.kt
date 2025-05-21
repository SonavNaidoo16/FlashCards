package vcmsa.sonav.flashcards

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code start here
        val reviewText = findViewById<TextView>(R.id.tvReviewS1)
        val radioWall = findViewById<RadioButton>(R.id.radBW)
        val radioTitanic = findViewById<RadioButton>(R.id.radTS)
        val radioPyramids = findViewById<RadioButton>(R.id.radBP)
        val radioUS = findViewById<RadioButton>(R.id.radGW)
        val radioCivil = findViewById<RadioButton>(R.id.radMLK)
        val showbtn = findViewById<Button>(R.id.btnShow)
        val exitBtn = findViewById<Button>(R.id.btnExitMain)

        //set a click listener on the exit button
        exitBtn.setOnClickListener {
            finishAffinity()
        }
            //set a click listener on the show answers button
            showbtn.setOnClickListener {
                Log.d("ReviewScreen", "Suggest button clicked")

                if (!radioWall.isChecked && !radioTitanic.isChecked && !radioPyramids.isChecked && !radioUS.isChecked && !radioCivil.isChecked
                ) {
                    reviewText.text = "Please pick an option!"
                    Log.d("ReviewScreen", "Suggest button clicked")
                } else {
                    val selected = when {
                        //Information retrieved from https://www.wikipedia.org/
                        //Berlin wall: https://en.wikipedia.org/wiki/Berlin_Wall
                        //Titanic: https://www.worldhistory.org/RMS_Titanic/
                        //Pyramids: https://www.encyclopedia.com/history/news-wires-white-papers-and-books/technology-and-engineering-building-pyramids#:~:text=The%20best-known%20monuments%20from%20ancient%20Egypt%20are%20the,used%20extremely%20simple%20technology%20to%20accomplish%20sophisticated%20ends.
                        //US: https://learningenglish.voanews.com/a/george-washington-first-president/7972056.html
                        //Civil: https://interestingliterature.com/2022/10/martin-luther-king-i-have-a-dream-speech-summary-analysis/
                        radioWall.isChecked -> listOf("The Berlin Wall was a guarded concrete barrier that encircled West Berlin from 1961 to 1989, separating it from East Berlin and the German Democratic Republic,")
                        radioTitanic.isChecked -> listOf("RMS Titanic sank on 15 April 1912 in the North Atlantic Ocean.")
                        radioPyramids.isChecked -> listOf("The ancient Egyptians built the pyramids through innovative engineering, human strength, and careful organization.")
                        radioUS.isChecked -> listOf("The first president of the United States was George Washington, starting in 1789")
                        radioCivil.isChecked -> listOf("‘I Have a Dream’ is one of the greatest speeches in American history. Delivered by Martin Luther King, Jr. (1929-68) in Washington D.C. in 1963")
                        else -> "Please pick an option!"
                    }
                    reviewText.text = selected.toString()

                    //log review question
                    Log.d("ReviewScreen", "Suggest button clicked")
                }
            }
        }
    }
//end of code