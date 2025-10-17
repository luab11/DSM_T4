package com.example.mycityapp.data

data class Recommendation(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val address: String,
    val rating: Float,
    val image: Int? = null
)