package com.example.collegeschedule_romankov.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun GroupDropdown(
    groups: List<String>,
    selectedGroup: String,
    onGroupSelected: (String) -> Unit
) {
    val expanded = remember { mutableStateOf(false) }
    val query = remember { mutableStateOf(selectedGroup) }

    val filteredGroups = groups.filter {
        it.contains(query.value, ignoreCase = true)
    }

    OutlinedTextField(
        value = query.value,
        onValueChange = {
            query.value = it
            expanded.value = true
        },
        label = { Text("Группа") },
        modifier = Modifier.fillMaxWidth()
    )

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }
    ) {
        filteredGroups.forEach { group ->
            DropdownMenuItem(
                text = { Text(group) },
                onClick = {
                    query.value = group
                    onGroupSelected(group)
                    expanded.value = false
                }
            )
        }
    }
}