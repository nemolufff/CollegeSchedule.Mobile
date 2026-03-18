package com.example.collegeschedule_romankov.data.dto

data class LessonPartDto(
    val subject: String,
    val teacher: String,
    val teacherPosition: String,
    val classroom: String,
    val building: String,
    val address: String
)