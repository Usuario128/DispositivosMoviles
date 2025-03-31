package com.example.myapplication.Proyecto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen(tasks: List<Task>) {
    val completedTasks = tasks.count { it.isCompleted }
    val totalTasks = tasks.size

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Estadísticas") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Tareas completadas: $completedTasks")
            Text("Tareas totales: $totalTasks")
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(progress = if (totalTasks == 0) 0f else completedTasks.toFloat() / totalTasks)
        }
    }
}

@Preview
@Composable
fun PreviewStatsScreen() {
    StatsScreen(tasks = listOf(Task(1, "Task 1", "Description", true), Task(2, "Task 2", "Description", false)))
}