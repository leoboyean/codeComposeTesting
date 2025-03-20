package com.genius.myappjpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.genius.myappjpackcompose.core.navigation.NavigationWrapper
import com.genius.myappjpackcompose.ui.theme.MyAppJPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            mifirstComposable()
            MyAppJPackComposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
                NavigationWrapper()
            }
        }
    }
}

@Composable
fun mifirstComposable() {

    Column( modifier = Modifier.fillMaxSize().padding(top = 35.dp, start = 10.dp) ) {
        Text("My Name is:")
        Spacer(modifier = Modifier.height(12.dp))
        Text("Hello World!")
    }
}


