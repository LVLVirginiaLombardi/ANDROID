package com.example.myappwithmvvm.ui.theme.addname.domain

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.data.repository.DataRepository
import com.example.myappwithmvvm.ui.theme.addname.data.repository.Repository

class SaveNameListUseCase(application: Application) {
    private val repository: Repository = DataRepository(application)
    fun execute(items: List<String>) = repository.saveName(items)
}