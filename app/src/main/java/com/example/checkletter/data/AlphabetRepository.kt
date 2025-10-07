package com.example.checkletter.data

interface AlphabetRepository {
    fun getAlphabetData(): List<Pair<Char, String>>
    fun getNextAlphabet(currentAlphabet: Pair<Char, String>): Pair<Char, String>

}