package com.example.taskplanner.ui.viewmodel
// Модель данных Task
import com.example.taskplanner.data.model.Task

// Для ViewModel
import androidx.lifecycle.ViewModel

// Для работы с состоянием в Compose
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

// Для UUID
import java.util.UUID


class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateOf<List<Task>>(emptyList())
    val tasks: State<List<Task>> = _tasks
    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task

    }

    fun toggleTaskStatus(taskId: UUID) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == taskId) {
                task.copy(isCompleted = !task.isCompleted)
            } else {
                task
            }
        }
    }
}