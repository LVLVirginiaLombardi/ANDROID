package com.example.myappwithmvvm.ui.theme.addname.presentation.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.myappwithmvvm.ui.theme.addname.domain.AddNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.RemoveNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.presentation.actions.AddNameAction
import com.example.myappwithmvvm.ui.theme.addname.presentation.intents.AddNameIntent
import com.example.myappwithmvvm.ui.theme.addname.presentation.processor.AddNameProcessor
import com.example.myappwithmvvm.ui.theme.addname.presentation.results.AddNameResult

class AddNameViewModel(application: Application) : AndroidViewModel(application) {

    val processor = AddNameProcessor(application)

    val items = mutableStateOf(listOf<String>())

    fun reducer(result: AddNameResult) {
        when(result) {
            is AddNameResult.GetListName -> {
                items.value = result.itemList
            }

            is AddNameResult.AddName -> {
                items.value = result.items
            }
            is AddNameResult.RemoveName -> {
                items.value = result.items
            }
            else ->  { }
        }
    }

    fun onIntent(intent: AddNameIntent) {
        when(intent) {
            is AddNameIntent.LoadNameList -> {
                val result = processor.getResult(action = AddNameAction.LoadNameListAction)
                reducer(result)
            }
            is AddNameIntent.AddItem -> {
                val resultAddName = processor.addItemResult(
                    action = AddNameAction.AddItemToList(newItem = intent.newItem),
                    newItem = intent.newItem
                )
                reducer(resultAddName)
            }
            is AddNameIntent.RemoveItem -> {
                val resultRemoveName = processor.removeItemResult(
                    action = AddNameAction.RemoveItemFromList(intent.index),
                    index = intent.index
                )
                reducer(resultRemoveName)
            }
        }
    }
}
