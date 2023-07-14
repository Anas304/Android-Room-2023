package com.example.roomdb

import android.app.Application
import com.example.roomdb.data.AppContainer
import com.example.roomdb.data.AppDataContainer

class ItemApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }



}