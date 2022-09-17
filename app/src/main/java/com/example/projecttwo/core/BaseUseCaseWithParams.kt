package com.example.projecttwo.core

interface BaseUseCaseWithParams<Params, Result> {

    suspend fun invoke(params: Params): Result

}