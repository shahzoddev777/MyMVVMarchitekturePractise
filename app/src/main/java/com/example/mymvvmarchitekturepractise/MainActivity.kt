package com.example.mymvvmarchitekturepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.mymvvmarchitekturepractise.ui.ContactScreen
import com.example.mymvvmarchitekturepractise.viewmodel.ContactViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val viewModel: ContactViewModel = viewModel()

                ContactScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
