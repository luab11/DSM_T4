package com.example.mycityapp.data

object LocalRecommendationsData {
    val recommendations = listOf(
        Recommendation(
            id = 1,
            name = "Café Central",
            description = "Un café acogedor en el centro de la ciudad.",
            category = "Cafeterías",
            address ="Calle Principal, 123",
            rating = 4.5f
        ),
        Recommendation(
            id = 2,
            name = "Libro y Café",
            description = "Cafetería con una gran selección de libros.",
            category = "Cafeterías",
            address ="Avenida Central, 456",
            rating = 4.2f
        ),
        Recommendation(
            id = 3,
            name = "Restaurante La Terraza",
            description = "Comida internacional con vista al parque.",
            category = "Restaurantes",
            address ="Boulevard Norte, 789",
            rating = 4.8f
        ),
        Recommendation(
            id = 4,
            name = "Pizzería Napoli",
            description = "Las mejores pizzas al estilo italiano.",
            category = "Restaurantes",
            address ="Calle Sur, 987",
            rating = 4.6f
        ),
        Recommendation(
            id = 5,
            name = "Parque Central",
            description = "Un gran parque para pasear y hacer deporte.",
            category = "Parques",
            address ="Avenida Principal, 321",
            rating = 4.0f
        ),
        Recommendation(
            id = 6,
            name = "Jardín Botánico",
            description = "Disfruta de la naturaleza y la tranquilidad.",
            category = "Parques",
            address ="Boulevard Sur, 654",
            rating = 4.3f
        )
        // Añade más recomendaciones según necesites
    )

    fun getCategories(): List<String> {
        return recommendations.map { it.category }.distinct()
    }

    fun getRecommendationsByCategory(category: String): List<Recommendation> {
        return recommendations.filter { it.category == category }
    }

    fun getRecommendationById(id: Int): Recommendation? {
        return recommendations.find { it.id == id }
    }
}