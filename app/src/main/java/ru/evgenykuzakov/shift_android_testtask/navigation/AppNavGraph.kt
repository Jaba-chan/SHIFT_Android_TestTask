package ru.evgenykuzakov.shift_android_testtask.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    showUsersScreenContent: @Composable () -> Unit,
    userDetailInfoScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ShowUsersScreen.route

    ) {
        composable(Screen.ShowUsersScreen.route) {
            showUsersScreenContent()
        }
        composable(Screen.UserDetailInfoScreen.route) {
            userDetailInfoScreenContent()
        }
    }
}