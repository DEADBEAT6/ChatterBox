
package com.raj.chatterbox.Screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raj.chatterbox.ViewModel.AuthViewModel
import com.raj.chatterbox.ViewModel.MessageViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,

) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignupScreen.route
    ) {
        composable(Screen.SignupScreen.route) {
            SignUpScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = { navController.navigate(Screen.LoginScreen.route)},
                onSignUpSuccess = {navController.navigate(Screen.LoginScreen.route)}
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToSignUp = { navController.navigate(Screen.SignupScreen.route) },
                onSignInSuccess = {navController.navigate(Screen.ChatRoomsScreen.route)}
            )
        }
        composable(Screen.ChatRoomsScreen.route) {
            ChatRoomListScreen (
                onJoinClicked = {navController.navigate("${Screen.ChatScreen.route}/${it.id}")}
            )
        }
        composable("${Screen.ChatScreen.route}/{roomId}") {
            val roomId: String = it.arguments?.getString("roomId") ?: ""
            ChatScreen(roomId = roomId)
        }

        }
}