package com.example.mycityapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycityapp.ui.screens.CategoryScreen
import com.example.mycityapp.ui.screens.DetailScreen
import com.example.mycityapp.view.screens.HomeScreen
import com.example.mycityapp.viewmodel.RecommendationsViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    viewModel: RecommendationsViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onCategoryClick = { category ->
                    navController.navigate("category/$category")
                }
            )
        }
        composable("category/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            CategoryScreen(
                viewModel = viewModel,
                category = categoryName,
                onRecommendationClick = { recommendationId ->
                    navController.navigate("detail/$recommendationId")
                },
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("detail/{recommendationId}") { backStackEntry ->
            val recommendationId = backStackEntry.arguments?.getString("recommendationId")?.toIntOrNull() ?: 0
            DetailScreen(
                viewModel = viewModel,
                recommendationId = recommendationId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}