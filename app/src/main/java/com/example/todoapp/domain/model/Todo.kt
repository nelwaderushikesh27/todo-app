package com.example.todoapp.domain.model

import java.time.LocalDateTime

data class Todo(
    val id: Long = 0,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.LOW,
    val category: String = "Default",
    val dueDate: LocalDateTime? = null,
    val reminderDate: LocalDateTime? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

enum class Priority {
    LOW,
    MEDIUM,
    HIGH
}
