package com.example.todoapp.domain.model

data class Category(
    val id: Long = 0,
    val name: String,
    val color: Long = 0xFF6366F1,
    val icon: String = "📁",
    val todoCount: Int = 0
)

val defaultCategories = listOf(
    Category(name = "Personal", color = 0xFF22C55E, icon = "🏠"),
    Category(name = "Work", color = 0xFF3B82F6, icon = "💼"),
    Category(name = "Shopping", color = 0xFFF59E0B, icon = "🛒"),
    Category(name = "Health", color = 0xFFEF4444, icon = "❤️"),
    Category(name = "Learning", color = 0xFF8B5CF6, icon = "📚")
)
