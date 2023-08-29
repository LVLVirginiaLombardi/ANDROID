package com.example.myappwithmvvm.ui.theme.addname.presentation.processor

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.domain.AddNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.GetNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.domain.RemoveNameListUseCase
import com.example.myappwithmvvm.ui.theme.addname.presentation.actions.AddNameAction
import com.example.myappwithmvvm.ui.theme.addname.presentation.results.AddNameResult

class AddNameProcessor(application: Application) {
    val getNameList = GetNameListUseCase(application)
    val addItem = AddNameListUseCase(application)
    val removeItem = RemoveNameListUseCase(application)

    fun getResult(action: AddNameAction): AddNameResult {
        return if (action == AddNameAction.LoadNameListAction) {
            AddNameResult.GetListName(getNameList.execute())
        } else {
            AddNameResult.Default
        }
    }

    fun addItemResult(action: AddNameAction, newItem: String): AddNameResult {
        return if (action == AddNameAction.AddItemToList(newItem)) {
            AddNameResult.AddName(addItem.execute(newItem))
        } else {
            AddNameResult.Default
        }
    }

    fun removeItemResult(action: AddNameAction, index: Int): AddNameResult {
        return if (action == AddNameAction.RemoveItemFromList(index)) {
            AddNameResult.RemoveName(removeItem.execute(index))
        } else {
            AddNameResult.Default
        }
    }
}