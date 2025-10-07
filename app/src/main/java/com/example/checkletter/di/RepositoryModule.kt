package com.example.checkletter.di

import com.example.checkletter.data.AlphabetRepository
import com.example.checkletter.data.AlphabetRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAlphabetRepository(): AlphabetRepository {
        return AlphabetRepositoryImpl()
    }
}



