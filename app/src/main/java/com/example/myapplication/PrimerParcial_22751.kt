package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun juego() {

    var qr by remember {
        mutableStateOf("0")
    }

    var qw by remember {
        mutableStateOf("0")
    }

    var JANNIK by remember {
        mutableIntStateOf(0)
    }
    var BOB by remember {
        mutableIntStateOf(0)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(8.dp)){
        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(80.dp)
                    .background(color = Color.Green)) {
                }
                Spacer(modifier = Modifier.width(3.dp))
                Column {
                    Box(modifier = Modifier
                        .height(74.dp)
                        .width(210.dp)
                        .background(color = Color.Green)) {

                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Box(modifier = Modifier
                        .height(74.dp)
                        .width(210.dp)
                        .background(color = Color.Green)) {

                    }

                }
                Spacer(modifier = Modifier.width(3.dp))
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(80.dp)
                    .background(color = Color.Green)) {
                }
            }

            Text(text = " ", modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
                .height(5.dp))

            Row {
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(80.dp)
                    .background(color = Color.Green)) {
                }
                Spacer(modifier = Modifier.width(3.dp))
                Column {
                    Box(modifier = Modifier
                        .height(73.dp)
                        .width(210.dp)
                        .background(color = Color.Green)) {

                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Box(modifier = Modifier
                        .height(73.dp)
                        .width(210.dp)
                        .background(color = Color.Green)) {

                    }

                }
                Spacer(modifier = Modifier.width(3.dp))
                Box(modifier = Modifier
                    .height(150.dp)
                    .width(80.dp)
                    .background(color = Color.Green)) {
                }
            }

            Spacer(modifier = Modifier.height(50.dp))


            Row (modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Image(painter = painterResource(id = R.drawable.player_one),
                        contentDescription = "Jugador", Modifier.size(120.dp))

                    Text(text = "Jannik Sinner", color = Color.Black)

                    Row (modifier = Modifier.align(Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically) {


                        IconButton(onClick = {
                            if (JANNIK <= 0)
                                JANNIK = 0

                            else
                                JANNIK = JANNIK - 15},
                            modifier = Modifier
                        ) { Icon(imageVector = Icons.Default.AddCircle, contentDescription = "icono")
                        }

                        Text(text = "$JANNIK")


                        IconButton(onClick = {
                            if (JANNIK == 30)
                                JANNIK = JANNIK + 10


                            if (JANNIK >= 40)
                                qr = "SET"

                            else
                                JANNIK = JANNIK + 15
                        },
                            modifier = Modifier
                        ) { Icon(imageVector = Icons.Default.Add, contentDescription = "icono")
                        }


                    }
                }

                Spacer(modifier = Modifier.width(50.dp))

                Text(text = "VS", style = TextStyle(fontWeight = Bold))

                Spacer(modifier = Modifier.width(50.dp))

                Column {

                    Image(painter = painterResource(id = R.drawable.player_two),
                        contentDescription = "Jugador", Modifier.size(120.dp))

                    Text(text = "Minion Bob", color = Color.Black)

                    Row (modifier = Modifier.align(Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically) {


                        IconButton(onClick = {
                            if (BOB <= 0)
                                BOB = 0

                            else
                                BOB = BOB - 15
                            qw = BOB.toString()},
                            modifier = Modifier
                        ) { Icon(imageVector = Icons.Default.AddCircle, contentDescription = "icono")
                        }

                        Text(text = "$BOB")


                        IconButton(onClick = {
                            if (BOB == 30)
                                BOB = BOB + 10

                            if (BOB >= 40)
                                qw = "SET"

                            else BOB = BOB + 15
                        },
                            modifier = Modifier
                        ) { Icon(imageVector = Icons.Default.Add, contentDescription = "icono")
                        }
                    }
                }

            }
        }
    }
}