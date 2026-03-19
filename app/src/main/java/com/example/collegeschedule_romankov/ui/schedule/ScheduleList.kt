package com.example.collegeschedule_romankov.ui.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collegeschedule_romankov.data.dto.ScheduleByDateDto
import androidx.compose.ui.graphics.Color

@Composable
fun ScheduleList(data: List<ScheduleByDateDto>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(data) { day ->
            Text(
                "${day.lessonDate} (${day.weekday})",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
            if (day.lessons.isEmpty()) {
                Text(
                    "Информация отсутствует",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                )
            } else {
                day.lessons.forEach { lesson ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        colors = androidx.compose.material3.CardDefaults.cardColors(
                            containerColor = Color(0x330073B7)
                        )
                    ) {
                        Column(Modifier.padding(12.dp)) {

                            Text(
                                text = "Пара ${lesson.lessonNumber}",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Text(
                                text = lesson.time,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            lesson.groupParts.forEach { (part, info) ->
                                if (info != null) {

                                    Text(
                                        text = "📚 ${info.subject}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )

                                    Text(
                                        text = "👨‍🏫 ${info.teacher}",
                                        style = MaterialTheme.typography.bodySmall
                                    )

                                    Text(
                                        text = "📍 ${info.building}, ${info.classroom}",
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}