package com.example.taskplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier

import com.example.taskplanner.ui.theme.TaskPlannerTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import com.example.taskplanner.ui.viewmodel.TaskViewModel

import androidx.lifecycle.viewmodel.compose.viewModel



import com.example.taskplanner.navigation.TaskNavigation



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TaskPlannerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel:TaskViewModel=viewModel()
                    TaskNavigation(viewModel)
                }
            }

        }
    }
}


