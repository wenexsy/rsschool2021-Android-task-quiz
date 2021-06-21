package com.rsschool.quiz



object Constants {


    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
      val questionList = ArrayList<Question>()

        val que1 = Question(1,"Сколько на Земле материков начинаются на букву «А»?" ,
            "2",
            "1",
            "3",
            "5",
            "6",
        4
        )
        questionList.add(que1)

        val que2 = Question(2,"Сколько раз цифра 3 используется в записи двузначных чисел?,",
            "19",
            "35",
            "12",
            "43",
            "8",
            1

        )
        questionList.add(que2)

        val que3 = Question(3,"2 +2 =?",
            "1",
            "2",
            "3",
            "4",
            "5",
            4
        )
        questionList.add(que3)

        val que4 = Question(4,"Сколько суток составляют високосный год?",
            "365",
            "28",
            "29",
            "366",
            "364",
            4
        )
        questionList.add(que4)

        val que5 = Question(5,"Сколько ног у улитки?",
            "1",
            "2",
            "6",
            "4",
            "10",
            1
        )
        questionList.add(que5)
        return questionList
    }

}