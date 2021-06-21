package com.rsschool.quiz

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rsschool.quiz.databinding.ActivityMainBinding
import com.rsschool.quiz.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {


    private lateinit var resultat: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultat = ActivityResultBinding.inflate(layoutInflater)
        setContentView(resultat.root)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        resultat.tvName.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        resultat.tvScore.text = "Your Score is $correctAnswers out of $totalQuestions."

        resultat.btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
        resultat.btnShare.setOnClickListener {

            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, resultat.tvScore.text)
                type = "text/plain"
            }


            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {

            }
            }
        }
    }



