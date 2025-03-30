package com.genius.myappjpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateToDetail: (String) -> Unit, navigateToList: () -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Home screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.weight(1f))
        TextField(value = text, onValueChange = {text = it})
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navigateToDetail(text)
        }) {
            Text(text = "Go to Details")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navigateToList()
        }) {
            Text(text = "Go to List")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ){
        HomeScreen( {
        }, {
        })
    }
}