package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable

fun contabilidad(){
    val i1: Int = 2000
    val e1: Int = 500
    var r1 by remember {mutableStateOf(" ")}
    val r1Color = if (r1.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i2: Int = 2000
    val e2: Int = 500
    var r2 by remember {mutableStateOf(" ")}
    val r2Color = if (r2.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i3: Int = 2000
    val e3: Int = 500
    var r3 by remember {mutableStateOf(" ")}
    val r3Color = if (r3.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i4: Int = 4000
    val e4: Int = 4500
    var r4 by remember {mutableStateOf(" ")}
    val r4Color = if (r4.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i5: Int = 4000
    val e5: Int = 1200
    var r5 by remember {mutableStateOf(" ")}
    val r5Color = if (r5.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i6: Int = 4000
    val e6: Int = 3000
    var r6 by remember {mutableStateOf(" ")}
    val r6Color = if (r6.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i7: Int = 8000
    val e7: Int = 4500
    var r7 by remember {mutableStateOf(" ")}
    val r7Color = if (r7.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i8: Int = 8000
    val e8: Int = 4500
    var r8 by remember {mutableStateOf(" ")}
    val r8Color = if (r8.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i9: Int = 8000
    val e9: Int = 4650
    var r9 by remember {mutableStateOf(" ")}
    val r9Color = if (r9.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i10: Int = 12000
    val e10: Int = 6000
    var r10 by remember {mutableStateOf(" ")}
    val r10Color = if (r10.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i11: Int = 12000
    val e11: Int = 6000
    var r11 by remember {mutableStateOf(" ")}
    val r11Color = if (r11.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    val i12: Int = 25000
    val e12: Int = 75000
    var r12 by remember {mutableStateOf(" ") }
    val r12Color = if (r12.toIntOrNull() ?: 0 < 0) Color.Red else Color.Black

    var imagen by remember {
        mutableStateOf(R.drawable.alemania)
    }

    var cambio by remember {
        mutableStateOf(false)
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End) {
            Image(painter = painterResource(id = imagen),
                contentDescription = "bandera",
                modifier = Modifier.size(70.dp))
        }
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Contabilidad de Alfonso Estudiante",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
        Column (){
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "",
                    color = Color.Blue,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(text = "Ingresos",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "Egresos",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "Neto",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Enero",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i1",
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e1",
                    color = Color.Black,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r1",
                    color = r1Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Febrero",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i2",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e2",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r2",
                    color = r2Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Marzo",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i3",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e3",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r3",
                    color = r3Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Abril",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i4",
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e4",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r4",
                    color = r4Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Mayo",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i5",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e5",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r5",
                    color = r5Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Junio",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i6",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e6",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r6",
                    color = r6Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Julio",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i7",
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e7",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r7",
                    color = r7Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Agosto",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i8",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e8",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r8",
                    color = r8Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Septiembre",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i9",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e9",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r9",
                    color = r9Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Octubre",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i10",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e10",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r10",
                    color = r10Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Noviembre",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i11",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e11",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r11",
                    color = r11Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Column {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(text = "Diciembre",
                    color = Color.White, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color(0xFF17911F))
                )
                Text(text = "$i12",
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$e12",
                    color = Color.Black, modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
                Text(text = "$r12",
                    color = r12Color,
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.White)
                )
            }
        }
        Button(onClick = {
            if (!cambio) {
                imagen = R.drawable.alemania
            }else {
                imagen = R.drawable.mexico
                r1 = (i1 - e1).toString()
                r2 = (i2 - e2).toString()
                r3 = (i3 - e3).toString()
                r4 = (i4 - e4).toString()
                r5 = (i5 - e5).toString()
                r6 = (i6 - e6).toString()
                r7 = (i7 - e7).toString()
                r8 = (i8 - e8).toString()
                r9 = (i9 - e9).toString()
                r10 = (i10 - e10).toString()
                r11 = (i11 - e11).toString()
                r12 = (i12 - e12).toString()
            }
            cambio = !cambio
            },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Resultados")
        }
    }
}