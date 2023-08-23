package com.example.myappwithmvvm.ui.theme.addname.presentation.viewmodels

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myappwithmvvm.ui.theme.addname.domain.AddNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.GetNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.RemoveNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.SaveNameListUseCase

class AddNameViewModel(application: Application) : AndroidViewModel(application) {

    private val userCase = GetNameListUseCase(application)
    private val removeItem = RemoveNameListUseCase(application)
    private val addItem = AddNameListUseCase(application)

    val items = mutableStateOf(loadItemsFromSharedPreferences())

    fun addItem(item: String) {
        items.value = addItem.execute(item)
    }

    fun removeItem(index: Int) {
        items.value = removeItem.execute(index)
    }

    private fun loadItemsFromSharedPreferences(): List<String> {
        return userCase.execute()
    }
}
