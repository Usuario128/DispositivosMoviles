package com.example.myapplication.Proyecto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onLanguageChange: (String) -> Unit, onNotificationToggle: (Boolean) -> Unit) {
    var language by remember { mutableStateOf("es") }
    var notificationsEnabled by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Configuración") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Idioma:")
            Row {
                RadioButton(selected = language == "es", onClick = { language = "es"; onLanguageChange("es") })
                Text("Español")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(selected = language == "en", onClick = { language = "en"; onLanguageChange("en") })
                Text("Inglés")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Text("Notificaciones")
                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it; onNotificationToggle(it) }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(onLanguageChange = {}, onNotificationToggle = {})
}