package com.example.checkletter.ui.test

import com.example.checkletter.data.FakeRepo
import com.example.checkletter.data.FakeRepository
import com.example.checkletter.data.ImageData.imagesData
import com.example.checkletter.ui.AlphabetViewModel
import com.example.checkletter.ui.ImageViewModel
import org.junit.Before
import org.junit.Test

class ImageViewModelTest {
    private lateinit var viewModel: ImageViewModel

    @Before
    fun setup() {
        viewModel = ImageViewModel(FakeRepo())
    }

    @Test
    fun testInitialUiState() {
        viewModel.nextImage()
        assert(viewModel.imageUiState.value.image.imageRes == imagesData[1].imageRes)
        assert(viewModel.imageUiState.value.image.name == imagesData[1].name)
    }
}