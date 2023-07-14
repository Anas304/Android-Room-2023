package com.example.roomdb.data

import android.content.Context
import com.example.roomdb.data.repository.ItemRepository
import com.example.roomdb.data.repository.OfflineItemsRepository
import com.example.roomdb.data.room.ItemDatabase

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemRepository
}


class AppDataContainer(private val context: Context) : AppContainer {
    /**With this declaration you can make sure that the itemsRepository property is
     * created lazily and reuse the same instance over and over again without creating
     * a new instance everytime you use it
     * * */
    override val itemsRepository: ItemRepository by lazy {
        OfflineItemsRepository(
            ItemDatabase.getDatabase(
                context
            ).itemDao()
        )
    }

    /** The declaration of itemsRepository propperty will provide a new instance of it
     * whenever itemsRespository is instentiated/called.
     *
     * override val itemsRepository: ItemRepository
        get() = OfflineItemsRepository(ItemDatabase.getDatabase(context).itemDao())*/
}
