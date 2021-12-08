package com.example.polyglotie.models

class Deck(
    val id: String="",
    val name: String= "",
    val quantity: Int,
    val wordsPair: Map< String, String>,
    val rating: Int = 0,
    val description: String ="",
    val category: String="",
    val authorName:String=""

)
