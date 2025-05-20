package com.example.myapplication.Ordinario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FloatingActionButton
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ordinario.examen.Result

@Preview(showBackground = true)
@Composable
fun Inicial(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Inicio") {
        composable(route = "Inicio"){
            com.example.ordinario.examen.Solicitar(navController)
        }
        composable(route = "juego?opcion={opcion}",
            arguments = listOf(
                navArgument("opcion"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            ))
        { parametros ->

            val opcion = parametros.arguments?.getInt("opcion") ?: 0
            Result(opcion, navController)
        }
    }
}




@Composable
fun Solicitar(navController: NavController) {

    var opcion by remember { mutableStateOf("") }
    Column() {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = opcion,
                onValueChange = {
                    opcion = it


                },
                placeholder = { Text(text = "¿Opcion a probar (1 ó 2)?") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FloatingActionButton(modifier = Modifier.background(color = Color.Red),
                onClick = { navController.navigate("juego?opcion=$opcion")},
            ) {
                Text(text = "Validar",
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))



            Text(text = "Marcelo Samuel Neri Ortiz 22751")


        }
    }
}