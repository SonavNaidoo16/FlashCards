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
            "The Berlin Wall was the wall that divided East and West Germany until 1989?", //true
            "1905 was the year the Titanic sink?", //false
            "China built the Egyptian pyramids?", //false
            "George Washington was the first President of the United States?", //true
            "Martin Luther King Jr. was the famous civil rights leader who gave the \"I Have a Dream\" speech?" //true
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
        //Ai assisted by chatGpt
        // Prompt pasted the above code and said "Please fix my code above to allow it verify if a user's answer to a question is correct"
        // Reset all radio buttons
        fun checkAnswer(userAnswer: Boolean) {
            if (userAnswer == answers[currentIndex]) {
                AnswerText.text = "Correct!"
                score++
                // end prompt
            } else {
                AnswerText.text = "Incorrect"
            }
            trueBtn.isEnabled = false
            falseBtn.isEnabled = false
        }
        //set a click listener on the true button
        trueBtn.setOnClickListener {
            checkAnswer(true)
        }
        ////set a click listener on the false button
        falseBtn.setOnClickListener {
            checkAnswer(false)
        }
        //set a click listener on the next button
        nextBtn.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()

            } else {

                    val intent = Intent(this, scoreScreen::class.java)
                        .putExtra("score",score)
                    startActivity(intent)
                }
            }
        }
    }
//end of code