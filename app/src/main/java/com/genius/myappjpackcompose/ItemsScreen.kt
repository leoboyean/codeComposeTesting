package com.genius.myappjpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ItemsScreen(name: String, onItemDetail: (String) -> Unit) {
    val text by remember { mutableStateOf("") }
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.padding(
            vertical = 4.dp, horizontal = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column (modifier = Modifier.weight(1f)) {
                    Text(text = "Compose Course:")
                    Text(text = name, style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ))
                }
                OutlinedButton(onClick = { onItemDetail(name) }) {
                    Text(text = "Show more", style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ))
                }
            }
        }

    }
}

@Composable
fun RecyclerView(
    names: List<String> = List(100){"$it"},
    onItemDetail: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
//        item(items(items = names))
        items(items= names) { nam ->
            ItemsScreen(nam, onItemDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val numbers = List(3){"$it"}
    RecyclerView(names = numbers, onItemDetail = {})
}