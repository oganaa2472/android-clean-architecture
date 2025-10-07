package com.example.checkletter.data

class FakeRepository (
    alphabets:List<Pair<Char,String>> = listOf(
        'A' to "Apple",
        'B' to "Ball",
        'C' to "Cat",
        'D' to "Dog",
    )
):AlphabetRepository by AlphabetRepositoryImpl(alphabets)