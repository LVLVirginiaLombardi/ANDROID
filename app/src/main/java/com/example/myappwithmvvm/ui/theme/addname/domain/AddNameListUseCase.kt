package com.example.myappwithmvvm.ui.theme.addname.domain

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.data.repository.DataRepository
import com.example.myappwithmvvm.ui.theme.addname.data.repository.Repository

class AddNameListUseCase(application: Application) {
    private val repository: Repository = DataRepository(application)
    fun execute(newItem: String): List<String> = repository.addListName(newItem)
}