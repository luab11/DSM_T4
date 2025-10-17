package com.example.mycityapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycityapp.ui.components.RecommendationCard
import com.example.mycityapp.ui.theme.GradientEnd
import com.example.mycityapp.ui.theme.GradientStart
import com.example.mycityapp.ui.theme.TextOnGradient
import com.example.mycityapp.viewmodel.RecommendationsViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun CategoryScreen(
    viewModel: RecommendationsViewModel,
    category: String,
    onRecommendationClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = category) {
        viewModel.setCurrentCategory(category)
    }

    val recommendations = viewModel.uiState.collectAsState().value.currentRecommendations
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(GradientStart, GradientEnd)
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp) // Padding mejorado
        ) {
            // Botón de retroceso mejorado con mejor contraste
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atrás",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Volver", fontWeight = FontWeight.Medium)
            }

            // Header de categoría con mejor espaciado
            Box(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .shadow(8.dp, RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = category,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Lista de recomendaciones con mejor espaciado
            if (recommendations.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(recommendations) { recommendation ->
                        RecommendationCard(
                            recommendation = recommendation,
                            onClick = { onRecommendationClick(recommendation.id) },
                            modifier = Modifier
                                .padding(vertical = 6.dp, horizontal = 4.dp)
                                .shadow(8.dp, RoundedCornerShape(12.dp))
                        )
                    }
                }
            } else {
                // Mensaje cuando no hay recomendaciones
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No hay recomendaciones disponibles",
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}