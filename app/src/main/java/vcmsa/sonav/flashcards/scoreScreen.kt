package vcmsa.sonav.flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.sonav.flashcards.R.id.btnPlayAgain

class scoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // code starts here
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnPlayAgain = findViewById<Button>(R.id.btnPlayAgain)
        val btnReview = findViewById<Button>(R.id.btnReview)

        // Score
        val score = intent.getIntExtra("score",0)

        tvScore.text = "$score / 5"

        // Feedback message
        tvFeedback.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practising!"
        }

        // Play Again button
        btnPlayAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Review button
        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewScreen::class.java)
            startActivity(intent)
        }
    }
}

