package com.example.projecttwo.domain.repository

import com.example.projecttwo.common.network.Resource
import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface FactRepository {
    suspend fun getFacts(): Flow<Resource<FactModelDTO>>
}