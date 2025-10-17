package com.example.mycityapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.LocalRecommendationsData
import com.example.mycityapp.model.RecommendationsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendationsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendationsUiState())
    val uiState: StateFlow<RecommendationsUiState> = _uiState.asStateFlow()

    fun setCurrentCategory(category: String) {
        _uiState.value = _uiState.value.copy(
            currentCategory = category,
            currentRecommendations = LocalRecommendationsData.getRecommendationsByCategory(category)
        )
    }

    fun setCurrentRecommendation(recommendationId: Int) {
        val recommendation = LocalRecommendationsData.getRecommendationById(recommendationId)
        _uiState.value = _uiState.value.copy(currentRecommendation = recommendation)
    }

    fun getCategories(): List<String> {
        return LocalRecommendationsData.getCategories()
    }
}