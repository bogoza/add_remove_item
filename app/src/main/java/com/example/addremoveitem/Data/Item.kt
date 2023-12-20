package com.example.addremoveitem.Data

import java.util.UUID

data class Item(
    val id: UUID = UUID.randomUUID(),
    val image: String,
    val title: String
)