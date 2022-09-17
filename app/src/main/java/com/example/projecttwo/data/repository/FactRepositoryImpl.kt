package com.example.projecttwo.data.repository

import com.example.projecttwo.common.network.RequestHandler
import com.example.projecttwo.common.network.Resource
import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import com.example.projecttwo.domain.remoteDataSource.FactRemoteDataSource
import com.example.projecttwo.domain.repository.FactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val factRemoteDataSource: FactRemoteDataSource,
) : FactRepository , RequestHandler(){
    override suspend fun getFacts(): Flow<Resource<FactModelDTO>> = flow {
        emit(Resource.loading())
        emit(safeApiCall { factRemoteDataSource.getFacts() })
    }
}