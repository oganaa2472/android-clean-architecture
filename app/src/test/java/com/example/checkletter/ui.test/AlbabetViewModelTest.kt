package com.example.checkletter.ui.test


import com.example.checkletter.data.FakeRepository
import com.example.checkletter.ui.AlphabetViewModel
import org.junit.Before
import org.junit.Test

class AlphabetViewModelTest {
    private lateinit var viewModel: AlphabetViewModel

    @Before
    fun setup() {
        viewModel = AlphabetViewModel(FakeRepository())
    }

    @Test
    fun testInitialUiState() {
        viewModel.nextAlphabet()
        assert(viewModel.alphabetUiState.value.alphabet == 'A')
        assert(viewModel.alphabetUiState.value.word == "Apple")
        assert(!viewModel.alphabetUiState.value.isCompleted)
    }
    @Test
    fun testAlphabetChange() {
        viewModel.nextAlphabet()
        val uiState = viewModel.alphabetUiState.value
        assert(viewModel.alphabetUiState.value.alphabet == 'B')
        assert(viewModel.alphabetUiState.value.word == "Ball")
        assert(!viewModel.alphabetUiState.value.isCompleted)
    }
    @Test
    fun testAlphabetRepeat() {
        repeat(2) {
            viewModel.nextAlphabet()
        }
        val uiState = viewModel.alphabetUiState.value
        assert(viewModel.alphabetUiState.value.alphabet == 'B')
        assert(viewModel.alphabetUiState.value.word == "Ball")
        assert(!viewModel.alphabetUiState.value.isCompleted)
    }


}