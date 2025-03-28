package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Barras() {
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(Color.White)) {

        Text(
            text = "",
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth()
                .height(115.dp))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "",
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(115.dp))
        Spacer(modifier = Modifier.height(20.dp))


        Text(text = " ",
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth()
                .height(115.dp),
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth().weight(50f)
        ){
            Text(text = " ",
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxHeight()
                    .weight(27f))
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = " ",
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .fillMaxHeight()
                    .weight(27f)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = " ",
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxHeight()
                    .weight(27f)
            )
        }
    }
}
