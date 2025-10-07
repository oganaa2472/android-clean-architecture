package com.example.checkletter.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel


// Add this line if it's missing
@SuppressLint("SuspiciousIndentation")
@Composable
fun ImageExpScreen(modifier: Modifier = Modifier.Companion) {
    Scaffold {
            innerPadding -> Column(
        modifier = modifier.padding(innerPadding).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
//
        val imageViewModel: ImageViewModel = hiltViewModel()
        val imageiState: ImageUiState by  imageViewModel.imageUiState.collectAsState()

        // 3. Collect the state using the 'by' delegate for cleaner access
        Card{
            Image(
                painter = painterResource(id = imageiState.image.imageRes),
                contentDescription = stringResource(id = imageiState.image.name), // Also good to use it here
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                // Use stringResource to convert the ID to a String
                text = stringResource(id = imageiState.image.name),
                style = MaterialTheme.typography.bodyLarge,

                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth()

                // Changed padding for better spacing
            )
            Spacer(Modifier.height(8.dp))
        }
        Button(onClick = {
            imageViewModel.nextImage()
        }) {
            Text("Next")
        }
    }

    }
}
@Preview(showBackground = true)
@Composable
fun ImageExpScreenPreview() {
    ImageExpScreen()
}