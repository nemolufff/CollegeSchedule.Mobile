package com.example.collegeschedule_romankov.data.repository

import com.example.collegeschedule_romankov.data.api.ScheduleApi
import com.example.collegeschedule_romankov.data.dto.ScheduleByDateDto

class ScheduleRepository(private val api: ScheduleApi) {

    suspend fun loadSchedule(group: String): List<ScheduleByDateDto> {
        return api.getSchedule(
            groupName = group,
            start = "2026-01-12",
            end = "2026-01-17"
        )
    }
}