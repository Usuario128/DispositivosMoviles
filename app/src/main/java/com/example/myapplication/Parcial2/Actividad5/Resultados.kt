package com.example.myapplication.Parcial2.Actividad5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R

@Composable
fun Resultados(edad: Int) {
    Card(modifier = Modifier.fillMaxSize().background(color = Color.Cyan)) {
        Text(text = "")
        when {
            edad in 1..14 -> {
                Text(text = "Menor de edad")
                Image(
                    painter = painterResource(id = R.drawable.nino),
                    contentDescription = "Imagen de un niño"
                )
            }
            edad in 14..15 -> {
                Text(text = "Mayor de edad en Indonesia pero no en México")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 15..16 -> {
                Text(text = "Mayor de edad en Cuba pero no en México")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 16..17 -> {
                Text(text = "Mayor de edad en Corea del Norte pero no en México")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 17..18 -> {
                Text(text = "Mayor de edad en México y gran parte de Latinoamérica")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 18..19 -> {
                Text(text = "Mayor de edad en Corea del Sur")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 19..20 -> {
                Text(text = "Mayor de edad en Japón")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 20..65 -> {
                Text(text = "Mayor de edad en USA y posiblemente en todo el mundo")
                Image(
                    painter = painterResource(id = R.drawable.joven),
                    contentDescription = "Imagen de un joven"
                )
            }
            edad in 60..65 -> {
                Text(text = "Eres de la tercera edad")
                Image(
                    painter = painterResource(id = R.drawable.anciano),
                    contentDescription = "Imagen de un anciano"
                )
            }
            else -> {
                Text(text = "Ya te puedes jubilar")
                Image(
                    painter = painterResource(id = R.drawable.anciano),
                    contentDescription = "Imagen de un anciano"
                )
            }
        }

    }
}
