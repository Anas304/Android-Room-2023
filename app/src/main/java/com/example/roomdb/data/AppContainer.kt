package com.example.roomdb.data

import android.content.Context
import com.example.roomdb.data.repository.ItemRepository
import com.example.roomdb.data.repository.OfflineItemsRepository
import com.example.roomdb.data.room.ItemDatabase

interface AppContainer {
    val itemsRepository : ItemRepository
}


class AppDataContainer(private val context : Context) : AppContainer {
    override val itemsRepository: ItemRepository
        get() = OfflineItemsRepository(ItemDatabase.getDatabase(context).itemDao())
}
