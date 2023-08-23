package com.example.myappwithmvvm.ui.theme.addname.data

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.data.source.DataSourceFactory

class DataRepository(application: Application): Repository {

    private val dataSourceFactory = DataSourceFactory(application)

    override fun getListName(): List<String> {
        return dataSourceFactory.getCache().getListName()
    }

    override fun addListName(newItem: String): List<String> {
        return dataSourceFactory.getCache().addListName(newItem)
    }

    override fun saveName(items: List<String>) {
        return dataSourceFactory.getCache().saveName(items)
    }

    override fun removeName(index: Int): List<String> {
        return dataSourceFactory.getCache().removeName(index)
    }
}