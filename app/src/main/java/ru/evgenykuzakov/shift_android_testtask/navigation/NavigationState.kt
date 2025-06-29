package ru.evgenykuzakov.shift_android_testtask.navigation

import androidx.navigation.NavController
import ru.evgenykuzakov.shift_android_testtask.navigation.Screen

class NavigationState(
    private val navController: NavController
) {
    fun navigateTo(route: String){
        navController.navigate(route){
            launchSingleTop = true
            restoreState = true
        }
    }
}