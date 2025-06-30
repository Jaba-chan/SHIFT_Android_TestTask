package ru.evgenykuzakov.designsystem.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.designsystem.R
import ru.evgenykuzakov.designsystem.ui.BodyLargeText

@Composable
fun LoadingScreen(
    size: Dp = 32.dp
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(size)
        )
    }
}

@Composable
fun ErrorScreen(
    size: Dp = 32.dp,
    onRetryButtonClicked: () -> Unit
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(size)
        )
        Button(
            onClick = onRetryButtonClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ){
            BodyLargeText(text = stringResource(R.string.retry))
        }
    }
}