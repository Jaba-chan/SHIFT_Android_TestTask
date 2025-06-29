package ru.evgenykuzakov.users.show_users

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.evgenykuzakov.common.Resource
import ru.evgenykuzakov.users.R
import ru.evgenykuzakov.users.show_users.placeholder.BodyLargeText
import ru.evgenykuzakov.users.show_users.placeholder.LabelSmallText
import ru.evgenykuzakov.users.show_users.placeholder.StyledRow

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
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(items = users.data) {
                    Card(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onClick = {}
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = it.picture.large,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(120.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                LabelSmallText(
                                    text = "${it.name.first} ${it.name.last}",
                                )
                                StyledRow(
                                    text = it.phone,
                                    iconResId = R.drawable.ic_call,
                                )
                                StyledRow(
                                    text = "${it.location.city}, ${it.location.street.name}, ${it.location.street.number}",
                                    iconResId = R.drawable.ic_home,
                                )
                            }
                        }
                    }
                }
            }
    }

}