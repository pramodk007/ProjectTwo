package com.example.projecttwo.domain.remoteDataSource

import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import retrofit2.Response

interface FactRemoteDataSource {
    suspend fun getFacts(): Response<FactModelDTO>
}