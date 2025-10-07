package com.example.checkletter.data

import com.example.checkletter.R



class FakeRepo(
    images:List<Item> = listOf(
        Item(R.string.compro_admission_team, R.drawable.compro_admission_team), // Make sure you have these drawables
        Item(R.string.compro_professionals, R.drawable.compro_professionals),
        Item(R.string.faculty_student, R.drawable.faculty_student),
        Item(R.string.friends, R.drawable.friends),
        Item(R.string.graduation, R.drawable.graduation),
        Item(R.string.miu_campus, R.drawable.miu_campus),
        Item(R.string.rainbow, R.drawable.rainbow),
        Item(R.string.sustainable_living, R.drawable.sustainable_living_center),
    )
):ImageRepository by ImageRepositoryImpl(images)