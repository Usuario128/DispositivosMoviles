package com.example.myapplication.Parcial2.Actividad5


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun Solicitar() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Inicio") {
        composable(route = "Inicio"){
            Soli(navController)
        }
        composable(route = "estudiante?edad={edad}",
            arguments = listOf(
                navArgument("edad"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            ))
        { parametros ->

            val edad = parametros.arguments?.getInt("edad") ?: 0
            Resultados(edad)
        }
    }
}

@Composable
fun Soli(navController: NavController) {

    var año by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = año,
            onValueChange = {
                año = it
                // Aquí calculamos la edad cuando el valor del año cambia
                if (año.isNotEmpty()) {
                    edad = 2025 - año.toInt()  // Calcula la edad con el año actual (2025 en este caso)
                }
            },
            placeholder = { Text(text = "Año de Nacimiento") }
        )

        FloatingActionButton(onClick = { navController.navigate("estudiante?edad=$edad") }) {
            Text(text = "Calcular -->")
        }
    }
}