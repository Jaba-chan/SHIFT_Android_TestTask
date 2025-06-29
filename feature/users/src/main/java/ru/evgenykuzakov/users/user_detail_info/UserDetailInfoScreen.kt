package ru.evgenykuzakov.users.user_detail_info

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.evgenykuzakov.common.Resource
import ru.evgenykuzakov.users.show_users.placeholder.BodyLargeText

@Composable
fun UserDetailInfoScreen(
    paddingValues: PaddingValues,
    viewModel: UserDetailInfoViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    when(val user = state.user){
        is Resource.Error -> {}
        is Resource.Loading -> {}
        is Resource.Success -> {
            Card(
                modifier = Modifier.padding(paddingValues)
            ) {
                BodyLargeText(
                    text = user.data.name.toString()
                )
            }
        }
    }

}