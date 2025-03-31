package com.example.myapplication.Proyecto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(task: Task, onSave: (Task) -> Unit, onDelete: (Task) -> Unit) {
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalle de Tarea") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = { onDelete(task) }) {
                    Text("Eliminar")
                }
                Button(onClick = { onSave(task.copy(title = title, description = description)) }) {
                    Text("Guardar")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTaskDetailScreen() {
    TaskDetailScreen(
        task = Task(1, "Título", "Descripción", false),
        onSave = {},
        onDelete = {}
    )
}