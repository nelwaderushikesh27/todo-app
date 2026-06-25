package com.example.todoapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.model.Todo
import com.example.todoapp.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    
    init {
        loadTodos()
    }
    
    private fun loadTodos() {
        viewModelScope.launch {
            repository.getAllTodos()
                .combine(_searchQuery) { todos, query ->
                    if (query.isBlank()) {
                        todos
                    } else {
                        todos.filter {
                            it.title.contains(query, ignoreCase = true) ||
                            it.description.contains(query, ignoreCase = true)
                        }
                    }
                }
                .collect { todos ->
                    _uiState.value = _uiState.value.copy(
                        todos = todos,
                        pendingCount = todos.count { !it.isCompleted },
                        completedCount = todos.count { it.isCompleted }
                    )
                }
        }
    }
    
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }
    
    fun toggleTodoCompletion(todo: Todo) {
        viewModelScope.launch {
            repository.updateTodo(
                todo.copy(
                    isCompleted = !todo.isCompleted,
                    updatedAt = java.time.LocalDateTime.now()
                )
            )
        }
    }
    
    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }
    
    fun showAddTodoDialog() {
        _uiState.value = _uiState.value.copy(showAddDialog = true)
    }
    
    fun hideAddTodoDialog() {
        _uiState.value = _uiState.value.copy(showAddDialog = false)
    }
}

data class HomeUiState(
    val todos: List<Todo> = emptyList(),
    val pendingCount: Int = 0,
    val completedCount: Int = 0,
    val showAddDialog: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
