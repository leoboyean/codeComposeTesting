package com.genius.myappjpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.genius.myappjpackcompose.core.navigation.SettingsInfo

@Composable
fun DetailScreen(name: String, navigateToSettings: (SettingsInfo) -> Unit, navigateBack: () -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Detail screen $name", fontSize = 24.sp)
        Spacer(modifier = Modifier.weight(1f))
//        TextField(value = text, onValueChange = {text = it})
//        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            val settingsInfo = SettingsInfo(
                name = "Gato",
                id = 1,
                darkModel = true,
                attached = true
            )
            navigateToSettings(settingsInfo)
        }) {
            Text(text = "Go to Settings")
        }
        Button(onClick = {
            navigateBack()
        }) {
            Text(text = "Logout")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}