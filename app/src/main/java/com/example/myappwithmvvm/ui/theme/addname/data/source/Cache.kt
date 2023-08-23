package com.example.myappwithmvvm.ui.theme.addname.data.source

interface Cache {
    fun getListName(): List<String>
    fun addListName(newItem: String): List<String>
    fun saveName(items: List<String>)
    fun removeName(index: Int): List<String>
}