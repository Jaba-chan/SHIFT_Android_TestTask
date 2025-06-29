package ru.evgenykuzakov.shift_android_testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.evgenykuzakov.shift_android_testtask.navigation.AppNavGraph
import ru.evgenykuzakov.shift_android_testtask.navigation.NavigationState
import ru.evgenykuzakov.shift_android_testtask.navigation.Screen
import ru.evgenykuzakov.shift_android_testtask.ui.theme.SHIFT_Android_TestTaskTheme
import ru.evgenykuzakov.users.show_users.ShowUsersScreen
import ru.evgenykuzakov.users.user_detail_info.UserDetailInfoScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SHIFT_Android_TestTaskTheme {

                val navController = rememberNavController()
                val navState = remember { NavigationState(navController) }

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                   AppNavGraph(
                       navHostController = navController,
                       showUsersScreenContent = {
                           ShowUsersScreen(
                               paddingValues = innerPadding,
                               onUserClick = {
                                   navState.navigateTo(Screen.UserDetailInfoScreen.createRoute(it))
                               }
                           )
                       },
                       userDetailInfoScreenContent = {
                           UserDetailInfoScreen(
                               paddingValues = innerPadding
                           )
                       }
                   )
                }
            }
        }
    }
}
