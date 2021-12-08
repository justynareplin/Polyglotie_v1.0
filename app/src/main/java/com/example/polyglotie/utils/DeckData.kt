package com.example.polyglotie.utils

import com.example.polyglotie.models.Deck

object DeckData {
    val basicWordsSet= HashMap<String, String>()

    fun getBasicWords():HashMap<String, String>{
        val basicWordsSet= HashMap<String, String>()
        basicWordsSet.put("hello", "czesc")
        basicWordsSet.put("thanks", "dzieki")
        return basicWordsSet
    }

    val deck1 = Deck("1",
        "Deck1",
        5,
        basicWordsSet,
        0,
        "Basic words set for beginners",
        "Basic vocabulary",
        "Justyna"
    )
}