package com.example.myapplication.Parcial2.Tarea3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R

@Preview(showBackground = true)
@Composable
fun Bienvenida() {
    // Crea el NavController de Bienvenida
    val navController = rememberNavController()

    // Define el NavHost para esta pantalla
    NavHost(navController = navController, startDestination = "Inicio") {
        composable(route = "Inicio") {
            PantallaInicio(navController)
        }
        composable(route = "Formulario") {
            Formulario()
        }
    }
}

@Composable
fun PantallaInicio(navController: NavController) {

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 4.dp



    Column(modifier = Modifier.fillMaxSize()) {
        // Mensaje de bienvenida
        Text(text = "Bienvenido a la pantalla de inicio")

        // Botón para navegar a la pantalla de formulario
        ExtendedFloatingActionButton(onClick = { navController.navigate("Formulario") }) {
            Text(text = "Ir al formulario -->")
        }

        Image(
            painter = painterResource(id = R.drawable.bienvenida),
            contentDescription = stringResource(id = R.drawable.bienvenida),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush),
                    CircleShape
                )
                .padding(borderWidth)
                .clip(CircleShape)
        )

    }
}