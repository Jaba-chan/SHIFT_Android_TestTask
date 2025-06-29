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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ru.evgenykuzakov.shift_android_testtask.ui.theme.SHIFT_Android_TestTaskTheme
import ru.evgenykuzakov.users.show_users.ShowUsersScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SHIFT_Android_TestTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ShowUsersScreen(
                        paddingValues = innerPadding
                    )
                }
            }
        }
    }
}
