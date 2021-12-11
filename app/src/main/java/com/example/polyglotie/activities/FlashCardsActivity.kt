package com.example.polyglotie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.polyglotie.R

class FlashCardsActivity : BaseQuizActivities() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_cards)
        var btnFavouriteClicks = 0

        val tvDeckTitle: TextView = findViewById(R.id.deck_title)
        val tWordsQuantity: TextView = findViewById(R.id.deck_words_quantity)
        val tvRating: TextView = findViewById(R.id.tv_rating)
        val tvYourLevel: TextView = findViewById(R.id.tv_your_level)

        val btnFavourites: ImageButton = findViewById(R.id.favourite_button)
        val backBtn: ImageButton = findViewById(R.id.backBtn)
        val btnWords: Button = findViewById(R.id.btn_flashcard)

        btnWords.setText("Word ang")

        setDeckDetails(tvDeckTitle, tWordsQuantity, tvRating, tvYourLevel)

        btnFavourites.setOnClickListener {
            btnFavouriteClicks++
            if (btnFavouriteClicks == 1) {
                /*   val question = gQuestionsList!![questionCurrentPosition]
                   val questionEnglish = question.question
                   val questionPolish = question.answer.toString()
                   Favourites.favouriteWords.put(questionEnglish, questionPolish)*/

                favouriteButtonClicked(btnFavourites)
            } else if (btnFavouriteClicks == 2) {
                btnFavouriteClicks = 0
                favouriteButtonClickedTwice(btnFavourites)
            }
        }
        backBtn.setOnClickListener {
            setBackBtn(backBtn)
        }
        btnWords.setOnClickListener {
            btnWords.setText("word pl")
        }

    }
}