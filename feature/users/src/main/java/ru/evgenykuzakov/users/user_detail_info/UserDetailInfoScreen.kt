package ru.evgenykuzakov.users.user_detail_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.evgenykuzakov.common.Resource
import ru.evgenykuzakov.common.util.toStringDate
import ru.evgenykuzakov.designsystem.ui.BodyLargeText
import ru.evgenykuzakov.designsystem.ui.HeadingCard
import ru.evgenykuzakov.designsystem.ui.LabelSmallText
import ru.evgenykuzakov.designsystem.ui.theme.LoadingScreen
import ru.evgenykuzakov.users.R

@Composable
fun UserDetailInfoScreen(
    paddingValues: PaddingValues,
    viewModel: UserDetailInfoViewModel = hiltViewModel(),
    onBackClicked: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    when (val user = state.user) {
        is Resource.Error -> {}
        is Resource.Loading -> {
            LoadingScreen()
        }
        is Resource.Success -> {
            val userData = user.data
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 12.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(
                   onClick = onBackClicked
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                BodyLargeText(text = "${stringResource(R.string.id)} ${userData.id.name}: ${userData.id.value}")
                AsyncImage(
                    model = userData.picture.large,
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                )
                LabelSmallText(text = "${userData.name.title} ${userData.name.first} ${userData.name.last}, ${userData.gender}")
                BodyLargeText(
                    text = "${stringResource(R.string.nationality)} ${userData.nat}",
                    textAlign = TextAlign.Center)
                HeadingCard(
                    headingText = stringResource(R.string.contacts)
                ) {
                    BodyLargeText(text = "${stringResource(R.string.email)} ${userData.email}")
                    BodyLargeText(text = "${stringResource(R.string.phone)} ${userData.phone}")
                    BodyLargeText(text = "${stringResource(R.string.cell)} ${userData.cell}")
                }
                Row {
                    HeadingCard(
                        modifier = Modifier.weight(1f),
                        headingText = stringResource(R.string.registered)
                    ) {
                        BodyLargeText(text = "${stringResource(R.string.date)} ${userData.registered.date.toStringDate()}")
                        BodyLargeText(text = "${stringResource(R.string.registered_age)} ${userData.registered.age}")
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    HeadingCard(
                        modifier = Modifier.weight(1f),
                        headingText = stringResource(R.string.dob)
                    ) {
                        BodyLargeText(text = "${stringResource(R.string.date)} ${userData.dob.date.toStringDate()}")
                        BodyLargeText(text = "${stringResource(R.string.person_age)} ${userData.dob.age}")
                    }
                }
                HeadingCard(
                        headingText = stringResource(R.string.location)
                        ) {
                    BodyLargeText(text = "${stringResource(R.string.country)} ${userData.location.country}, ${userData.location.state}")
                    BodyLargeText(text = "${stringResource(R.string.address)} ${userData.location.street.name}, ${userData.location.street.number}")
                    BodyLargeText(text = "${stringResource(R.string.postcode)} ${userData.location.postcode}")
                    BodyLargeText(text = "${stringResource(R.string.timezone)} ${userData.location.timezone.description}, ${userData.location.timezone.offset}")
                }
                HeadingCard(
                    headingText = stringResource(R.string.login)
                ) {
                    BodyLargeText(text = "${stringResource(R.string.username)} ${userData.login.username}")
                    BodyLargeText(text = "${stringResource(R.string.password)} ${userData.login.password}")
                    BodyLargeText(text = "${stringResource(R.string.uuid)} ${userData.login.uuid}")
                }
            }
        }
    }
}
