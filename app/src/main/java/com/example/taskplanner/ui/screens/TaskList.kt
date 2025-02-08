package com.example.taskplanner.ui.screens

// Основные компоненты Compose UI
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.PaddingValues


//Ленивый список (Аналог RecyclerView)
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

//Material Design компоненты
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text


//Базовые компоненты Compose
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskplanner.ui.theme.TaskPlannerTheme
*/

// Импорт модели
import com.example.taskplanner.data.model.Task
// Импорт
import androidx.compose.foundation.clickable


@Composable
fun TaskList(
    tasks: List<Task>,
    onTaskClick:(Task) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(tasks) { task -> TaskItem(task = task, onTaskClick={onTaskClick(task)}) }
    }
}

@Composable
fun TaskItem(
    task: Task,
    onTaskClick: () ->Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable{onTaskClick()},
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = {onTaskClick() }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)


            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,

                    )
                if (task.description.isNotEmpty()) {
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}



/*
@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    TaskPlannerTheme {
        TaskList(
            tasks = listOf(
                Task(title = "Сходить в магазин", description = "Купить продукты"),
                Task(title = "Позвонить маме", description = "Обсудить выходные", isCompleted = true),
                Task(title = "Сделать домашку", description = "Математика, страница 24")
            ),
            onTaskClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    TaskPlannerTheme {
        TaskItem(
            task = Task(
                title = "Тестовая задача",
                description = "Описание тестовой задачи"
            ),
            onTaskClick = { }
        )
    }
}
*/