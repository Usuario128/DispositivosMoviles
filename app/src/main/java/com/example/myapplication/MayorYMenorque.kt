package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MayorYMenorQue() {

    var firstNumber by remember { mutableStateOf("") }

    var secondNumber by remember { mutableStateOf("") }

    var thirdNumber by remember { mutableStateOf("") }

    var mayorNumber by remember { mutableStateOf(0) }

    var menorNumber by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Dame tres números para comparar")


        Text(text = "Ingresa el primer número:")
        TextField(
            value = firstNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Primer número") },
            onValueChange = { firstNumber = it }
        )

        Text(text = "Ingresa el segundo número:")
        TextField(
            value = secondNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Segundo número") },
            onValueChange = { secondNumber = it }
        )

        Text(text = "Ingresa el tercer número:")
        TextField(
            value = thirdNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Tercer número") },
            onValueChange = { thirdNumber = it }
        )

        Button(
            onClick = {
                val num1 = firstNumber.toInt()
                val num2 = secondNumber.toInt()
                val num3 = thirdNumber.toInt()

                mayorNumber = maxOf(num1, num2, num3)
                menorNumber = minOf(num1, num2, num3)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Calcular Mayor y Menor")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "El número mayor es: $mayorNumber")
        Text(text = "El número menor es: $menorNumber")
    }
}