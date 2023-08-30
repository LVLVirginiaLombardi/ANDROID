package com.example.myappwithmvvm.ui.theme.addname.di

import android.content.Context
import com.example.myappwithmvvm.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [])
interface AppComponent {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun addNameComponent(): AddNameComponent.Factory
    fun inject(activity: MainActivity)
}
