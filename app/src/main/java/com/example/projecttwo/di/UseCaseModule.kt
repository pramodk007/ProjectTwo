package com.example.projecttwo.di

import com.example.projecttwo.domain.repository.FactRepository
import com.example.projecttwo.domain.useCase.FactUseCase
import com.example.projecttwo.domain.useCase.FactUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsUseCase(
        repository: FactRepository
    ): FactUseCase = FactUseCaseImpl(repository)
}