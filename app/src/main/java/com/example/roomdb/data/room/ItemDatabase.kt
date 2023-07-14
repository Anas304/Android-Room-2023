package com.example.roomdb.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        @Volatile
        private var instance: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = ItemDatabase::class.java,
                    name = "items_Table"
                )
                    .build()
                    .also { instance = it } // also create instance of this newly created database
            }
        }
    }
}