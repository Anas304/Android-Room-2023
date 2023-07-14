package com.example.roomdb.data.repository

import com.example.roomdb.data.room.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItemStream(): Flow<List<Item>>

    fun getItemStream(id: Int): Flow<Item?>

    suspend fun insertItem(item: Item)

    suspend fun updateItem(item: Item)

    suspend fun deleteItem(item: Item)

}