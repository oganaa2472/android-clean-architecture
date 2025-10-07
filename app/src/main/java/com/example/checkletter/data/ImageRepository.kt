package com.example.checkletter.data

interface ImageRepository {
    fun getImageData(): List<Item>
    fun getNextImage(currentAlphabet: Item): Item
}