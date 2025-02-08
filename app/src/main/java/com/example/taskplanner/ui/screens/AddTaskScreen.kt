package com.example.taskplanner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskplanner.ui.theme.TaskPlannerTheme
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onTaskAdded:(String,String)-> Unit,
    onNavigateBack:()->Unit
){
    var title by remember{mutableStateOf("")}
    var description by remember{mutableStateOf("")}
    Scaffold(
        topBar={
            TopAppBar(
                title={Text("Новая задача")},
                navigationIcon={
                    IconButton(onClick=onNavigateBack){
                        Icon(Icons.Default.ArrowBack,"Назад")
                    }
                }
            )
        }
    ){
        paddingValues ->
        Column(
            modifier=Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ){
            OutlinedTextField(
                value=title,
                onValueChange={title=it},
                label={Text("Заголовок")},
                modifier=Modifier.fillMaxWidth()
            )
            Spacer(modifier=Modifier.height(16.dp))

            OutlinedTextField(
                value=description,
                onValueChange={description=it},
                label={Text("Описание")},
                modifier=Modifier.fillMaxWidth(),
                minLines=3
            )
            Spacer(modifier=Modifier.height(16.dp))

            Button(
                onClick={
                    if (title.isNotBlank()){
                        onTaskAdded(title,description)
                        onNavigateBack()
                    }
                },
                modifier=Modifier.fillMaxWidth(),
                enabled=title.isNotBlank()
            ){
                Text("Добавить задачу")
            }
        }

    }
}
/*@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    TaskPlannerTheme {
        AddTaskScreen(
            onTaskAdded = { _, _ -> },
            onNavigateBack = { }
        )
    }
}
*/