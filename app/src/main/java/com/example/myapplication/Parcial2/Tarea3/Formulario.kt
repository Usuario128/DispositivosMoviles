package com.example.myapplication.Parcial2.Tarea3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
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
fun Formulario() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Inicio") {
        composable(route = "Inicio"){
            Form(navController)
        }
        composable(route = "estudiante?nombre={nombre}&id={id}",
            arguments = listOf(
                navArgument("nombre"){
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "-"
                },
                navArgument("id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            ))
        { parametros ->
            val studentName = parametros.arguments?.getString("nombre") ?: "-"
            val studentId = parametros.arguments?.getInt("id") ?: 0
            Datos(studentId, studentName)
        }
    }
}

@Composable
fun Form(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = nombre, onValueChange = {nombre = it}, placeholder = { Text(text = "Nombre")})
        TextField(value = id, onValueChange = {id = it}, placeholder = { Text(text = "ID")})

        ExtendedFloatingActionButton(onClick = { navController.navigate("estudiante?nombre=$nombre&id=$id") }){
            Text(text = "A estudiante -->")
        }
    }

}