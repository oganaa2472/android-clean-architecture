package com.example.checkletter.ui

import androidx.lifecycle.ViewModel
import com.example.checkletter.data.AlphabetData
import com.example.checkletter.data.AlphabetRepository
import com.example.checkletter.data.AlphabetRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class AlphabetViewModel @Inject constructor(
    private val alphabetRepository: AlphabetRepository = AlphabetRepositoryImpl()
): ViewModel()  {
    private val alphabetData = alphabetRepository.getAlphabetData()
    // mutableStateFlow


    private val _alphabetUiState = MutableStateFlow(
        AlphabetUiState(alphabet = alphabetData[0].first, word = alphabetData[0].second)
    )


    val alphabetUiState: StateFlow<AlphabetUiState> = _alphabetUiState.asStateFlow()


    fun nextAlphabet() {
//        val nextIndex = alphabetData.indexOfFirst { it.first == _alphabetUiState.value.alphabet }
//        _alphabetUiState.update {it->
//            if(nextIndex == alphabetData.size - 1){
//                it.copy(
//                    alphabet = alphabetData[0].first,
//                    word = alphabetData[0].second
//                )
//            }else{
//                it.copy(
//                    alphabet = alphabetData[nextIndex + 1].first,
//                    word = alphabetData[nextIndex + 1].second
//                )
//            }
//
//        }
//
//            _alphabetUiState.update {it->
//                if(nextIndex == alphabetData.size - 2){
//                it.copy(
//                    isCompleted = true
//                )}else {
//                    it.copy(
//                        isCompleted = false
//                    )
//                }
//
//            }

            val nextAlphabet = alphabetRepository.getNextAlphabet(
                _alphabetUiState.value.alphabet to _alphabetUiState.value.word)

            if(nextAlphabet == alphabetData.last()){
                _alphabetUiState.update {
                    it.copy(
                        alphabet = nextAlphabet.first,
                        word = nextAlphabet.second,
                        isCompleted = true
                    )

                }
            }else{
                _alphabetUiState.update {
                    it.copy(
                        alphabet = nextAlphabet.first,
                        word = nextAlphabet.second,
                        isCompleted = false
                    )
                }
            }
    }
}