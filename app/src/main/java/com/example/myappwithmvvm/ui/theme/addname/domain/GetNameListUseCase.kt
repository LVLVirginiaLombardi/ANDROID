package com.example.myappwithmvvm.ui.theme.addname.domain

import android.app.Application
import com.example.myappwithmvvm.ui.theme.addname.data.DataRepository
import com.example.myappwithmvvm.ui.theme.addname.data.Repository

class GetNameListUseCase(application: Application) {
    private val repository: Repository = DataRepository(application)
    fun execute(): List<String> = repository.getListName()
}