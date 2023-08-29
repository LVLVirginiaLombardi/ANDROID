package com.example.myappwithmvvm.ui.theme.addname.presentation.intents

sealed class AddNameIntent {
    object LoadNameList: AddNameIntent()
    data class AddItem(val newItem: String): AddNameIntent()
    data class RemoveItem(val index: Int): AddNameIntent()
}
