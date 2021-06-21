package com.rsschool.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.QuiziActivity
import com.rsschool.quiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        var et_name = bindingClass.etName

        bindingClass.btnStart.setOnClickListener {


            if (et_name.text.toString().isEmpty())  {
                Toast.makeText(this, "please enter name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuiziActivity::class.java)
                intent.putExtra(
                    Constants.USER_NAME, et_name.text.toString()
                )
                startActivity(intent)
                finish()
            }

        }
    }
}

