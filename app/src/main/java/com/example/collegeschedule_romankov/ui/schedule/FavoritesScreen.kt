package com.example.collegeschedule_romankov.ui.schedule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesScreen(
    favorites: List<String>,
    onGroupClick: (String) -> Unit
) {
    if (favorites.isEmpty()) {
        Text(
            text = "Избранных групп нет",
            modifier = Modifier.padding(16.dp)
        )
    } else {
        LazyColumn {
            items(favorites) { group ->
                Column(
                    modifier = Modifier
                        .clickable { onGroupClick(group) }
                        .padding(16.dp)
                ) {
                    Text(text = group)
                }
            }
        }
    }
}