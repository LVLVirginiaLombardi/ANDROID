package com.example.myappwithmvvm.ui.theme.addname.data.source

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.data.cache.CacheImpl

class DataSourceFactory(application: Application) {
    private val cache: Cache = CacheImpl(application)

    fun getCache(): Cache = cache
}