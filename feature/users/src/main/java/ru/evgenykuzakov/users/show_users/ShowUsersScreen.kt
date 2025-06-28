package ru.evgenykuzakov.users.show_users

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.common.Resource

@Composable
fun ShowUsersScreen(
    viewModel: ShowUsersViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val uiState by viewModel.uiState.collectAsState()

    when (val users = uiState.users) {
        is Resource.Error -> {}
        is Resource.Loading -> {}
        is Resource.Success ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                items(items = users.data) {
                    Text(text = it.name.first + " " + it.name.last)
                }
            }
    }

}