package com.example.taskplanner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskplanner.ui.screens.AddTaskScreen
import com.example.taskplanner.ui.viewmodel.TaskViewModel
import com.example.taskplanner.data.model.Task
import com.example.taskplanner.ui.screens.TaskPlannerApp

sealed class Screen(val route: String) {
    object TaskList : Screen("taskList")
    object AddTask : Screen("addTask")
}

@Composable
fun TaskNavigation(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.TaskList.route
    ) {
        composable(Screen.TaskList.route){
            TaskPlannerApp(
                viewModel=viewModel,
                onAddClick={
                    navController.navigate(Screen.AddTask.route)
                }
            )
        }

        composable(Screen.AddTask.route){
            AddTaskScreen(
                onTaskAdded={title, description ->
                    viewModel.addTask(
                        Task(
                            title=title,
                            description=description
                        )
                    )
                },
                onNavigateBack={
                    navController.popBackStack()
                }

            )
        }

    }
}