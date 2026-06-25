package com.example.todoapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    
    @Query("SELECT * FROM todos ORDER BY isCompleted ASC, priority DESC, createdAt DESC")
    fun getAllTodos(): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE isCompleted = 0 ORDER BY priority DESC, dueDate ASC")
    fun getPendingTodos(): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE isCompleted = 1 ORDER BY updatedAt DESC")
    fun getCompletedTodos(): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE category = :category ORDER BY isCompleted ASC, priority DESC")
    fun getTodosByCategory(category: String): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%'")
    fun searchTodos(query: String): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE id = :id")
    suspend fun getTodoById(id: Long): TodoEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity): Long
    
    @Update
    suspend fun updateTodo(todo: TodoEntity)
    
    @Delete
    suspend fun deleteTodo(todo: TodoEntity)
    
    @Query("DELETE FROM todos WHERE id = :id")
    suspend fun deleteTodoById(id: Long)
    
    @Query("UPDATE todos SET isCompleted = :isCompleted, updatedAt = :updatedAt WHERE id = :id")
    suspend fun updateTodoCompletion(id: Long, isCompleted: Boolean, updatedAt: String)
    
    @Query("SELECT COUNT(*) FROM todos WHERE isCompleted = 1")
    fun getCompletedCount(): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM todos WHERE isCompleted = 0")
    fun getPendingCount(): Flow<Int>
}
