package com.example.mycityapp.model

import com.example.mycityapp.data.Recommendation

data class RecommendationsUiState(
    val currentCategory: String = "",
    val currentRecommendations: List<Recommendation> = emptyList(),
    val currentRecommendation: Recommendation? = null
)