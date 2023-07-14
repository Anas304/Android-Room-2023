package com.example.roomdb.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM ITEMS_TABLE WHERE id = :id")
    fun getItem(id : Int) : Flow<Item>
    @Query("SELECT * FROM ITEMS_TABLE ORDER BY title ASC")
    fun getAllItems() : Flow<List<Item>>
}
