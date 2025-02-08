package com.example.taskplanner.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.taskplanner.ui.viewmodel.TaskViewModel

/*
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskplanner.ui.theme.TaskPlannerTheme
import com.example.taskplanner.data.model.Task
*/

@Composable
fun TaskPlannerApp(
    viewModel: TaskViewModel,
    onAddClick:()-> Unit
){
    val tasks by viewModel.tasks

    Scaffold(
        floatingActionButton={
            FloatingActionButton(
                onClick=onAddClick
            ){
                Icon(
                    imageVector=Icons.Default.Add,
                    contentDescription="Добавить задачу"
                )
            }
        }
    ){
        paddingValues ->
        TaskList(
            tasks=tasks,
            onTaskClick={task ->
                viewModel.toggleTaskStatus(task.id)
            },
            modifier=Modifier.padding(paddingValues)
        )
    }
}


/*
@Preview(showBackground = true)
@Composable
fun TaskPlannerAppPreview() {
    TaskPlannerTheme {
        val previewViewModel = TaskViewModel().apply {
            addTask(Task(title = "Превью задача 1", description = "Описание 1"))
            addTask(Task(title = "Превью задача 2", description = "Описание 2", isCompleted = true))
        }
        TaskPlannerApp(
            viewModel = previewViewModel,
            onAddClick = { }
        )
    }
}

*/



