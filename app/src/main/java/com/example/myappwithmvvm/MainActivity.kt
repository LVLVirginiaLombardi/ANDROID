package com.example.myappwithmvvm

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myappwithmvvm.ui.theme.MyAppWithMVVMTheme
import com.example.myappwithmvvm.ui.theme.addname.di.ViewModelFactory
import com.example.myappwithmvvm.ui.theme.addname.presentation.intents.AddNameIntent
import com.example.myappwithmvvm.ui.theme.addname.presentation.viewmodels.AddNameViewModel
import com.example.myappwithmvvm.ui.theme.addname.ui.views.AddNameScreen
import dagger.Component
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: AddNameViewModel =
        ViewModelProvider(
            this,
            viewModelFactory
        )[AddNameViewModel::class.java]

    override fun onStart() {
        super.onStart()
//        DaggerAddNameComponent.factory().create(coreComponent()).inject(this)
    }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onIntent(AddNameIntent.LoadNameList)
        setContent {
            MyAppWithMVVMTheme {
                AddNameScreen(viewModel)
            }

        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviwTest() {
    MyAppWithMVVMTheme {
        AddNameScreen(viewModel = AddNameViewModel())
    }
}

