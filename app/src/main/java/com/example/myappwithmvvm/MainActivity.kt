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
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myappwithmvvm.ui.theme.MyAppWithMVVMTheme
import com.example.myappwithmvvm.ui.theme.addname.presentation.intents.AddNameIntent
import com.example.myappwithmvvm.ui.theme.addname.presentation.viewmodels.AddNameViewModel
import com.example.myappwithmvvm.ui.theme.addname.ui.views.AddNameScreen

class MainActivity : ComponentActivity() {
    lateinit var viewModel: AddNameViewModel
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = AddNameViewModel(application)
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
        AddNameScreen(viewModel = AddNameViewModel(application = Application()))
    }
}

