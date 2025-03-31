package com.example.myapplication.Proyecto


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Task(val id: Int, val title: String, val description: String, val isCompleted: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onTaskClick: (Task) -> Unit, onAddTask: () -> Unit) {
    val tasks = remember { mutableStateListOf<Task>() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("PRODO - Tareas") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTask) {
                Text("+")
            }
        }
    ) { padding ->
        if (tasks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No hay tareas disponibles", textAlign = TextAlign.Center)
            }
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(tasks.size) { index ->
                    TaskItem(task = tasks[index], onClick = onTaskClick)
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onClick: (Task) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(task) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = task.title)
            Text(text = task.description)
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(onTaskClick = {}, onAddTask = {})
}