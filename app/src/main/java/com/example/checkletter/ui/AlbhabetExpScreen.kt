package com.example.checkletter.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.checkletter.data.AlphabetRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel

// Add this line if it's missing
@SuppressLint("SuspiciousIndentation")
@Composable
fun AlphabetExpScreen(modifier: Modifier = Modifier.Companion) {
    Scaffold {
            innerPadding -> Column(
            modifier = modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ){

//        val alphabetViewModel: AlphabetViewModel = viewModel{
//            AlphabetViewModel(AlphabetRepositoryImpl())
//        }
        val alphabetViewModel: AlphabetViewModel = hiltViewModel()
        val alphabetUiState: AlphabetUiState by  alphabetViewModel.alphabetUiState.collectAsState()



            // 3. Collect the state using the 'by' delegate for cleaner access

            Text("Alphabet = ${alphabetUiState.alphabet}")
            Button(onClick = {
                    alphabetViewModel.nextAlphabet()
                }) {
                    Text("Next")
            }
            when{

                alphabetUiState.isCompleted -> {
                    Text(text = "Complete")
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AlphabetExpScreenPreview() {
    AlphabetExpScreen()
}