package vcmsa.sonav.flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // code starts here
        val trueBtn = findViewById<Button>(R.id.btnTrue)
        val falseBtn = findViewById<Button>(R.id.btnFalse)
        val nextBtn = findViewById<Button>(R.id.btnNext)
        val questionText = findViewById<TextView>(R.id.tv_question)
        val AnswerText = findViewById<TextView>(R.id.tvAnswers)

        val questions = arrayOf(
            "Nelson Mandela was the president in 1994.",
            "The capital of France is Berlin.",
            "The human body has four lungs.",
            "Kotlin is used for Android development.",
            "Water freezes at 0°C."
        )
        val answers = arrayOf(true, false, false, true, true)
        var score = 0
        var currentIndex = 0

        // Question
        fun loadQuestion() {
            questionText.text = questions[currentIndex]
            AnswerText.text = ""
            trueBtn.isEnabled = true
            falseBtn.isEnabled = true
        }
        loadQuestion()

        //Question Answers
        fun checkAnswer(userAnswer: Boolean) {
            if (userAnswer == answers[currentIndex]) {
                AnswerText.text = "Correct!"
                score++
            } else {
                AnswerText.text = "Incorrect"
            }
            trueBtn.isEnabled = false
            falseBtn.isEnabled = false
        }
        trueBtn.setOnClickListener {
            checkAnswer(true)
        }
        falseBtn.setOnClickListener {
            checkAnswer(false)
        }
        nextBtn.setOnClickListener {
            //AI (pasted the above "fix my code")
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
                // end of prompt
            } else {

                    val intent = Intent(this, scoreScreen::class.java)
                        .putExtra("score",score)
                    startActivity(intent)
                }
            }
        }
    }