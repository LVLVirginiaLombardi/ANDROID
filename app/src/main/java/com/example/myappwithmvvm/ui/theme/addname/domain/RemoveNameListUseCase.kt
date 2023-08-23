package com.example.myappwithmvvm.ui.theme.addname.domain

import android.app.Application
import android.content.SharedPreferences
import com.example.myappwithmvvm.ui.theme.addname.data.DataRepository
import com.example.myappwithmvvm.ui.theme.addname.data.Repository

class RemoveNameListUseCase(
    application: Application
) {
    private val repository: Repository = DataRepository(application)
    fun execute(index: Int): List<String> = repository.removeName(index)
}