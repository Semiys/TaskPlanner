package com.example.taskplanner.data.model

import java.util.UUID

data class Task(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var description: String = "",
    var isCompleted: Boolean = false

)