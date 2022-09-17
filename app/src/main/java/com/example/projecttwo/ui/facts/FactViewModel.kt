package com.example.projecttwo.ui.facts

import com.example.projecttwo.core.BaseViewModel
import com.example.projecttwo.domain.model.FactModel
import com.example.projecttwo.domain.useCase.FactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val factUseCase: FactUseCase
) : BaseViewModel<FactModel>() {

    suspend fun getFacts() {
        resetState()
        return responseHandler(factUseCase.invoke())
    }

    private fun resetState() {
        _factFlow.value = _factFlow.value.copy(
            isLoading = false,
            data = null,
            errorMessage = "",
        )
    }
}