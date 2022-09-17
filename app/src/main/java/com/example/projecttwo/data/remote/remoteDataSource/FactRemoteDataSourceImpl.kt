package com.example.projecttwo.data.remote.remoteDataSource

import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import com.example.projecttwo.data.remote.apiService.FactApiService
import com.example.projecttwo.domain.remoteDataSource.FactRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class FactRemoteDataSourceImpl @Inject constructor(
    private val factApiService: FactApiService
) : FactRemoteDataSource {
    override suspend fun getFacts(): Response<FactModelDTO> {
        return factApiService.getFacts()
    }
}