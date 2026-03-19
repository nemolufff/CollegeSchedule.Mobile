package com.example.collegeschedule_romankov.ui.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.collegeschedule_romankov.data.dto.ScheduleByDateDto
import com.example.collegeschedule_romankov.data.network.RetrofitInstance
import com.example.collegeschedule_romankov.ui.components.GroupDropdown
import com.example.collegeschedule_romankov.utils.getWeekDateRange

@Composable
fun ScheduleScreen() {
    var schedule by remember {
        mutableStateOf<List<ScheduleByDateDto>>(emptyList())
    }
    var groups by remember {
        mutableStateOf<List<String>>(emptyList())
    }
    var selectedGroup by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(selectedGroup) {
        val (start, end) = getWeekDateRange()
        try {
            if (groups.isEmpty()) {
                groups = RetrofitInstance.api.getGroups().map { it.groupName }
            }

            if (selectedGroup.isNotBlank()) {
                schedule = RetrofitInstance.api.getSchedule(
                    selectedGroup,
                    start,
                    end
                )
            } else {
                schedule = emptyList()
            }

        } catch (e: Exception) {
            error = e.message
        } finally {
            loading = false
        }
    }

    Column {
        GroupDropdown(
            groups = groups,
            selectedGroup = selectedGroup,
            onGroupSelected = { group ->
                selectedGroup = group
            }
        )

        when {
            loading -> CircularProgressIndicator()
            error != null -> Text("Ошибка: $error")
            else -> ScheduleList(schedule)
        }
    }
}