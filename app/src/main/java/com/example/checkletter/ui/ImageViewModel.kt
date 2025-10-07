package com.example.checkletter.ui



import androidx.lifecycle.ViewModel
import com.example.checkletter.data.AlphabetData
import com.example.checkletter.data.AlphabetRepository
import com.example.checkletter.data.AlphabetRepositoryImpl
import com.example.checkletter.data.ImageRepository
import com.example.checkletter.data.ImageRepositoryImpl
import com.example.checkletter.data.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
// added hilt for using dependency injection
@HiltViewModel
class ImageViewModel @Inject constructor(
    private val imageRepository: ImageRepository = ImageRepositoryImpl()
): ViewModel()  {
    // list of the images list
    private val imagesData = imageRepository.getImageData()
    // mutableStateFlow


    private val _imageUiState = MutableStateFlow(
        ImageUiState(image = imagesData[0])
    )


    val imageUiState: StateFlow<ImageUiState> = _imageUiState.asStateFlow()
    fun nextImage() {
        val nextImage = imageRepository.getNextImage(_imageUiState.value.image)
//        val nextAlphabet = imageRepository.getNextImage(
//            _imageUiState.value to _imageUiState.value.word)

        if(nextImage == imagesData.last()){
            _imageUiState.update {
                it.copy(
                    image = nextImage,
                    isCompleted = true
                )
            }
        }else{
            _imageUiState.update {
                it.copy(
                    image = nextImage,
                    isCompleted = false
                )

            }
        }
    }

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

//        val nextAlphabet = alphabetRepository.getNextAlphabet(
//            _alphabetUiState.value.alphabet to _alphabetUiState.value.word)
//
//        if(nextAlphabet == alphabetData.last()){
//            _alphabetUiState.update {
//                it.copy(
//                    alphabet = nextAlphabet.first,
//                    word = nextAlphabet.second,
//                    isCompleted = true
//                )
//
//            }
//        }else{
//            _alphabetUiState.update {
//                it.copy(
//                    alphabet = nextAlphabet.first,
//                    word = nextAlphabet.second,
//                    isCompleted = false
//                )
//            }
//        }
    }
}