package com.example.roomdb.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_Table")
data class Item(
    @PrimaryKey
    val id: Int,
    val title: String
)