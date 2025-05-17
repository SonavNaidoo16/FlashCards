package vcmsa.sonav.flashcards

import android.os.Bundle
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
        val radioNelson = findViewById<RadioButton>(R.id.radNM)
        val radioFrance = findViewById<RadioButton>(R.id.radFrance)
        val radioLungs = findViewById<RadioButton>(R.id.radLungs)
        val radioKotlin = findViewById<RadioButton>(R.id.radKotlin)
        val radioWater = findViewById<RadioButton>(R.id.radWater)
        val showbtn = findViewById<Button>(R.id.btnShow)
        val exitBtn = findViewById<Button>(R.id.btnExitMain)

        //set a click listener on the exit button
        exitBtn.setOnClickListener {
            finishAffinity()

            //set a click listener on the show answers button
            showbtn.setOnClickListener {
                if (!radioNelson.isChecked && !radioFrance.isChecked && !radioLungs.isChecked && !radioKotlin.isChecked && !radioWater.isChecked
                ) {
                    reviewText.text = "Please pick an option!"
                } else {
                    val selected = when {
                        radioNelson.isChecked -> listOf("May 10, 1994 Nelson Mandela became President of the Republic of South Africa on May 10, 1994,")
                        radioFrance.isChecked -> listOf("The capital of France is Paris, which is known for its cultural, financial, and political dominance as a primate city within the country")
                        radioLungs.isChecked -> listOf("A typical human being has two lungs, essential for breathing and oxygen exchange.")
                        radioKotlin.isChecked -> listOf("Kotlin is a modern, statically typed programming language that has become the preferred choice for Android development.")
                        radioWater.isChecked -> listOf("The temperature of the freezing point of water is 0 °C, at which liquid water undergoes a phase transition to become solid ice at 1 atmosphere of pressure.")
                        else -> "Please pick an option!"
                    }
                    reviewText.text = selected.toString()
                }
            }
        }
    }
}