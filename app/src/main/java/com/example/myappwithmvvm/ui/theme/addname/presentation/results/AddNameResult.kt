package com.example.myappwithmvvm.ui.theme.addname.presentation.results

sealed class AddNameResult {
    object Default: AddNameResult()
    data class GetListName(val itemList: List<String>): AddNameResult()
    data class AddName(val items: List<String>): AddNameResult()
    data class RemoveName(val items: List<String>): AddNameResult()
}
