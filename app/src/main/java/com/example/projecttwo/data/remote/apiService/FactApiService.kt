package com.example.projecttwo.data.remote.apiService

import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import retrofit2.Response
import retrofit2.http.GET

interface FactApiService {

    @GET("fact")
    suspend fun getFacts(): Response<FactModelDTO>

}