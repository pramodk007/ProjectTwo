package com.example.projecttwo.di

import com.example.projecttwo.data.repository.FactRepositoryImpl
import com.example.projecttwo.domain.remoteDataSource.FactRemoteDataSource
import com.example.projecttwo.domain.repository.FactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFactRepository(
        factRemoteDataSource: FactRemoteDataSource
    ): FactRepository = FactRepositoryImpl(factRemoteDataSource)
}