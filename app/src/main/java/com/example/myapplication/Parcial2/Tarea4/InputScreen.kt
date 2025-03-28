package com.example.myapplication.Parcial2.Tarea4

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainApp() {
    val navController = rememberNavController() // Crear NavController
    val context = LocalContext.current
    val preferencias = Preferencias(context)

    // Configuración de las rutas para la navegación
    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            InputScreen(navController, preferencias) // Navegación a la pantalla de entrada
        }
        composable("products") {
            ProductListScreen(preferencias,navController) // Navegación a la pantalla de productos
        }
    }
}

@Composable
fun InputScreen(navController: NavController, preferencias: Preferencias) {
    val coroutineScope = rememberCoroutineScope()

    // Leer en tiempo real los cambios en el archivo
    val savedName = preferencias.name.collectAsState(initial = "---")
    val savedAge = preferencias.age.collectAsState(initial = -1)
    val savedHeight = preferencias.height.collectAsState(initial = 0f)
    val savedWallet = preferencias.wallet.collectAsState(initial = 0f)

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var wallet by remember { mutableStateOf("") }
    var isSwitchOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingrese su información personal")

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = wallet,
            onValueChange = { wallet = it },
            label = { Text("Dinero en Monedero") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Guardar en preferencias")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = isSwitchOn, onCheckedChange = { isSwitchOn = it })
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (isSwitchOn) {
                coroutineScope.launch {
                    // Guardar todos los datos
                    preferencias.saveAllData(
                        name = name,
                        age = age.toIntOrNull() ?: 0,
                        height = height.toFloatOrNull() ?: 0f,
                        wallet = wallet.toFloatOrNull() ?: 0f
                    )
                }
            }
        }) {
            Text(text = "Guardar datos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para redirigir al listado de productos
        Button(onClick = {
            navController.navigate("products") // Navegar a la pantalla de productos
        }) {
            Text(text = "Ir a productos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            coroutineScope.launch {
                // Limpiar todos los datos guardados
                preferencias.clearSession()
            }
        }) {
            Text(text = "Limpiar datos")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mostrar datos guardados
        Text(text = "Datos guardados:")
        Text(text = "Nombre: ${savedName.value}")
        Text(text = "Edad: ${savedAge.value}")
        Text(text = "Altura: ${savedHeight.value} m")
        Text(text = "Monedero: $${savedWallet.value}")
    }
}
