package com.example.myappwithmvvm.ui.theme.addname.data

interface Repository {
    fun getListName(): List<String>
    fun addListName(newItem: String): List<String>
    fun saveName(items: List<String>)
    fun removeName(index: Int): List<String>
}