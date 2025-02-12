package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Posiciones() {
    Column (modifier = Modifier
        .background(color = Color.Black)
        .padding(horizontal = 20.dp, vertical = 20.dp)
        .background(color = Color.White)
        .fillMaxSize()) {
        Row() {
            Box(modifier = Modifier
                .background(color = Color.Red)
                .width(120.dp)){
                Text(text = "Top Start", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopStart))
            }

            Box(modifier = Modifier
                .background(color = Color(0xFF4400FF))
                .width(120.dp)
                .height(200.dp)){
                Text(text = "Top", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopCenter))
            }

            Box(modifier = Modifier
                .background(color = Color(0xFFE067F5))
                .width(120.dp)
                .height(50.dp)){
                Text(text = "Top End", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd))
            }
        }
        Row {
            Box(modifier = Modifier
                .background(color = Color.Green)
                .width(150.dp)
                .height(180.dp)) {
                Text(
                    text = "Center Start", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                )
            }

            Box(modifier = Modifier
                .background(color = Color.Gray)
                .width(60.dp)
                .height(411.dp)) {
                Text(text = "Center", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center))
            }

            Box(modifier = Modifier
                .background(color = Color.Black)
                .width(150.dp)) {
                Text(text = "Center End", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterEnd))
            }
        }
        Row(){
            Box(modifier = Modifier
                .background(color = Color.Cyan)
                .width(90.dp)
                .height(200.dp)) {
                Text(
                    text = "Bottom Start", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
            }

            Box(modifier = Modifier
                .background(color = Color.DarkGray)
                .width(180.dp)
                .height(200.dp)) {
                Text(
                    text = "Bottom Center", color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
            }

            Box(modifier = Modifier
                .background(color = Color.Yellow)
                .width(90.dp)
                .height(200.dp)) {
                Text(
                    text = "Bottom End", color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )
            }

        }
    }
}