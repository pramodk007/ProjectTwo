package com.example.projecttwo.core

interface BaseUseCaseWithoutParams< R > {

    suspend fun invoke() : R

}