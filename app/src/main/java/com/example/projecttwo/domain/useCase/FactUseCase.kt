package com.example.projecttwo.domain.useCase

import com.example.projecttwo.common.network.Resource
import com.example.projecttwo.core.BaseUseCaseWithoutParams
import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import kotlinx.coroutines.flow.Flow

interface FactUseCase : BaseUseCaseWithoutParams<Flow<Resource<FactModelDTO>>> {
    override suspend operator fun invoke(): Flow<Resource<FactModelDTO>>
}