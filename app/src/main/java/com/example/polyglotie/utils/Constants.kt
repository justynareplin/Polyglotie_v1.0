package com.example.polyglotie.utils

import com.example.polyglotie.activities.Question

object Constants {
    const val USERS: String = "users"

    fun getQuestions(): ArrayList<Question>{

        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Pytanie nr 1",
            "slowo1.1 ",
            "slowo1.2",
            "slowo1.3",
            "slowo1.4",
            1)
        questionList.add(que1)

        val que2 = Question(
            2,
            "Wybierz slowo2",
            "slowo1",
            "slowo2",
            "slowo3",
            "slowo4",
            2)
        questionList.add(que2)
        val que3 = Question(
            3,
            "Wybierz slowo3",
            "slowo1",
            "slowo2",
            "slowo3",
            "slowo4",
            3)
        questionList.add(que3)

        return questionList

    }


}