package com.example.myappwithmvvm.ui.theme.addname.di

import android.content.Context
import com.example.myappwithmvvm.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        PresentationModule::class
    ],
    dependencies = [
        AddNameComponent::class
    ]
)
interface AddNameComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AddNameComponent
        fun inject(fragment: MainActivity)
    }
}

