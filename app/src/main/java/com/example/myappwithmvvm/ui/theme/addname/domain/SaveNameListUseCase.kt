package com.example.myappwithmvvm.ui.theme.addname.domain

import android.app.Application
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key.Companion.T
import com.example.myappwithmvvm.ui.theme.addname.data.DataRepository
import com.example.myappwithmvvm.ui.theme.addname.data.Repository

class SaveNameListUseCase(application: Application) {
    private val repository: Repository = DataRepository(application)
    fun execute(items: List<String>) = repository.saveName(items)
}