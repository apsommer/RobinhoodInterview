package com.sommerengineering.robinhoodinterview

data class Instrument (
    val id: String,
    val name: String,
    val ticker: String,
    val instrument_type: String,
    val current_price: Float,
    val previous_price: Float,
    val description: String
)