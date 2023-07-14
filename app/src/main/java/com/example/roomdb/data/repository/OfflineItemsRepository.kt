package com.example.roomdb.data.repository

import com.example.roomdb.data.room.Item
import com.example.roomdb.data.room.ItemDao
import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemRepository{

    override fun getAllItemStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id = id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item = item)

    override suspend fun updateItem(item: Item) = itemDao.update(item = item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item = item)
}