package com.example.myappwithmvvm.ui.theme.addname.presentation.actions

sealed class AddNameAction {
    object LoadNameListAction: AddNameAction()
    data class AddItemToList(val newItem: String): AddNameAction()
    data class RemoveItemFromList(val index: Int): AddNameAction()
}
