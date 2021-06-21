package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.rsschool.quiz.Constants
import com.rsschool.quiz.Question
import com.rsschool.quiz.R
import com.rsschool.quiz.ResultActivity
import com.rsschool.quiz.databinding.ActivityMainBinding
import com.rsschool.quiz.databinding.FragmentQuiziBinding
import java.util.*
import kotlin.collections.ArrayList

class QuiziActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bindingQuiziii: FragmentQuiziBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingQuiziii = FragmentQuiziBinding.inflate(layoutInflater)
        setContentView(bindingQuiziii.root)



        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        bindingQuiziii.tvOptionOne.setOnClickListener(this)
        bindingQuiziii.tvOptionTwo.setOnClickListener(this)
        bindingQuiziii.tvOptionThree.setOnClickListener(this)
        bindingQuiziii.tvOptionFour.setOnClickListener(this)
        bindingQuiziii.tvOptionFive.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size) {
            bindingQuiziii.btnSubmit.text = "FINISH"
        } else {
            bindingQuiziii.btnSubmit.text = "SUBMIT"
        }

        bindingQuiziii.progressBar.progress = mCurrentPosition
        bindingQuiziii.tvProgress.text = "$mCurrentPosition" + "/" + bindingQuiziii.progressBar.max

        bindingQuiziii.tvQuestion.text = question!!.question
        bindingQuiziii.tvOptionOne.text = question.optionOne
        bindingQuiziii.tvOptionTwo.text = question.optionTwo
        bindingQuiziii.tvOptionThree.text = question.optionThree
        bindingQuiziii.tvOptionFour.text = question.optionFour
        bindingQuiziii.tvOptionFive.text = question.optionFive
        bindingQuiziii.btnSubmit.setOnClickListener(this)
        bindingQuiziii.btnBack.setOnClickListener(this)


    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, bindingQuiziii.tvOptionOne)
        options.add(1, bindingQuiziii.tvOptionTwo)
        options.add(2, bindingQuiziii.tvOptionThree)
        options.add(3, bindingQuiziii.tvOptionFour)
        options.add(4, bindingQuiziii.tvOptionFive)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(bindingQuiziii.tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(bindingQuiziii.tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(bindingQuiziii.tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(bindingQuiziii.tvOptionFour, 4)
            }
            R.id.tv_option_five -> {
                selectedOptionView(bindingQuiziii.tvOptionFive, 5)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size
                        -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    checkanswer()
                }
            }
            R.id.btn_back -> {

            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)


    }

    private fun checkanswer() {
        val question = mQuestionList?.get(mCurrentPosition - 1)
        if (question!!.correctAnswer != mSelectedOptionPosition) {

        } else {
            mCorrectAnswers++
        }

        if (mCurrentPosition == mQuestionList!!.size) {
            bindingQuiziii.btnSubmit.text = "FINISH"
        } else {
            bindingQuiziii.btnSubmit.text = "GO TO NEXT QUESTION"
        }

        mSelectedOptionPosition = 0
    }


}

