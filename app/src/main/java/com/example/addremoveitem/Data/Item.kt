package com.example.addremoveitem.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Item(
    val id: UUID = UUID.randomUUID(),
    val image: String,
    val title: String
):Parcelable