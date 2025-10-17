package com.example.mycityapp.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycityapp.ui.components.CategoryCard
import com.example.mycityapp.ui.theme.GradientEnd
import com.example.mycityapp.ui.theme.GradientStart
import com.example.mycityapp.ui.theme.TextOnGradient
import com.example.mycityapp.viewmodel.RecommendationsViewModel

@Composable
fun HomeScreen(
    viewModel: RecommendationsViewModel,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = viewModel.getCategories()
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally) as Arrangement.Vertical
        ) {
            // Header con icono
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.2f))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Ciudad",
                        modifier = Modifier.size(40.dp),
                        tint = TextOnGradient
                    )
                }
                Text(
                    text = "Mi Ciudad App",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextOnGradient,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Descubre los mejores lugares",
                    fontSize = 16.sp,
                    color = TextOnGradient.copy(alpha = 0.9f)
                )
            }

            // Lista de categorías
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        onClick = { onCategoryClick(category) },
                        modifier = Modifier.shadow(8.dp, RoundedCornerShape(12.dp))
                    )
                }
            }
        }
    }
}