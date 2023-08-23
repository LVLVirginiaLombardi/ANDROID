package com.example.myappwithmvvm.ui.theme.addname.data.cache

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.myappwithmvvm.ui.theme.addname.constants.Constants
import com.example.myappwithmvvm.ui.theme.addname.data.source.Cache

class CacheImpl(application: Application): Cache {

    private val sharedPreferences =
        application.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

    override fun getListName(): List<String> {
        return sharedPreferences.getStringSet(
            Constants.KEY_ITEMS,
            emptySet())?.toList() ?: emptyList()
    }

    override fun addListName(newItem: String): List<String> {
        val currentItems = getListName().toMutableList()
        currentItems.add(newItem)
        saveName(currentItems)
        return currentItems
    }

    override fun saveName(items: List<String>) {
         sharedPreferences.edit()
            .putStringSet(Constants.KEY_ITEMS, items.toSet())
            .apply()
    }

    override fun removeName(index: Int): List<String> {
        val updatedList = getListName().toMutableList().apply { removeAt(index) }
        saveName(updatedList)
        return updatedList
    }
}