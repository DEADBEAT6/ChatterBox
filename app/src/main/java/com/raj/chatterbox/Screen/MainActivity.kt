package com.raj.chatterbox.Screen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.raj.chatterbox.ViewModel.AuthViewModel
import com.raj.chatterbox.ViewModel.MessageViewModel
import com.raj.chatterbox.ui.theme.ChatterBoxTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val authViewModel: AuthViewModel = viewModel()

            ChatterBoxTheme {
                    NavigationGraph(navController =  navController,authViewModel= authViewModel)

            }
        }
    }
}
