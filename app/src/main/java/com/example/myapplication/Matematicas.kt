package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Matematicas() {

    var firstNumber by remember {
        mutableStateOf("")
    }
    var secondNumber by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableIntStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(text = "Dame un número")
        TextField(value = firstNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {Text(text = "Ingresa un número")},
            onValueChange = {
                    textoIngresado -> firstNumber = textoIngresado
            })

        Text(text = "Dame un número")
        TextField(value = secondNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {Text(text = "Ingresa un número")},
            onValueChange = {
                    textoIngresado -> secondNumber = textoIngresado
            })

        Button(onClick = {result = firstNumber.toInt() + secondNumber.toInt()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) { Text(text = "Suma")
        }
        OutlinedButton(onClick = {result = firstNumber.toInt() - secondNumber.toInt()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Blue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) { Text(text = "Resta")
        }

        IconButton(onClick = {result = firstNumber.toInt() * secondNumber.toInt()},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) { Icon(imageVector = Icons.Default.AddCircle, contentDescription = "icono")
        }

        Image(painter = painterResource(id = R.drawable.playa),
            contentDescription = "fondo", contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    result = firstNumber.toInt() / secondNumber.toInt()
                }

        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = result.toString(),
            readOnly = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {Text(text = result.toString())},
            onValueChange = {
            })
    }
}