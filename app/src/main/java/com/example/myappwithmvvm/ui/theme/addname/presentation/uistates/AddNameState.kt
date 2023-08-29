package com.example.myappwithmvvm.ui.theme.addname.presentation.uistates

sealed class AddNameState {
    data class GetListState(val listItem: List<String>): AddNameState()
    data class AddItemState(val item: String): AddNameState()
    data class RemoveItemState(val index: Int): AddNameState()
}
