package com.example.checkletter.di

import com.example.checkletter.data.AlphabetRepository
import com.example.checkletter.data.AlphabetRepositoryImpl
import com.example.checkletter.data.ImageRepository
import com.example.checkletter.data.ImageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
// install hilt and added dependency injection class here to use hilt we added some
// data gradle file and build gradle file
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
//    fun provideAlphabetRepository(): AlphabetRepository {
//        return AlphabetRepositoryImpl()
//    }

      fun provideImageRepository(): ImageRepository {
          return ImageRepositoryImpl()
      }
}



