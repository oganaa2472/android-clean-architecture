package com.example.checkletter.data

class AlphabetRepositoryImpl(
    private val alphabetData: List<Pair<Char, String>> = AlphabetData.alphabetData
) :AlphabetRepository {

    override fun getAlphabetData()=alphabetData

    override fun getNextAlphabet(currentAlphabet: Pair<Char, String>): Pair<Char, String> {
        var alphabetData = getAlphabetData()
        val currentAlphabetIndex =alphabetData.indexOf(currentAlphabet)


        if(currentAlphabetIndex < alphabetData.size - 1){
            return alphabetData[currentAlphabetIndex+1]
        }else{
            return alphabetData.first();
        }
    }
}