package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todoapp.domain.model.Priority

@Composable
fun PriorityChip(
    priority: Priority,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (color, label) = when (priority) {
        Priority.HIGH -> Color(0xFFEF4444) to "High"
        Priority.MEDIUM -> Color(0xFFF59E0B) to "Medium"
        Priority.LOW -> Color(0xFF22C55E) to "Low"
    }
    
    FilterChip(
        selected = false,
        onClick = onClick,
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(color, MaterialTheme.shapes.small)
            )
        },
        modifier = modifier
    )
}
