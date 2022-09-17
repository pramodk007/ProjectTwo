package com.example.projecttwo.domain.useCase

import com.example.projecttwo.common.network.Resource
import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import com.example.projecttwo.domain.repository.FactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactUseCaseImpl @Inject constructor(
    private val repository: FactRepository,
) : FactUseCase {

    override suspend fun invoke(): Flow<Resource<FactModelDTO>> {
        return repository.getFacts()
    }
}