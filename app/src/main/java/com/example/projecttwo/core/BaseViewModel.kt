package com.example.projecttwo.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttwo.common.network.Resource
import com.example.projecttwo.data.remote.apiResponse.fact.FactModelDTO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {

    val _factFlow = MutableStateFlow(BaseViewState<T>())
    val factFlow = _factFlow.asStateFlow()

    fun <T> responseHandler(flow: Flow<Resource<T>>) {

        viewModelScope.launch {
            val data = flow.collect {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        val result = (it.data as FactModelDTO)
                        _factFlow.value = _factFlow.value.copy(isLoading = false, data = it.data.toPresentation().fact)
                        Log.d("log1", " success - $result")
                    }
                    Resource.Status.ERROR -> {
                        _factFlow.value = _factFlow.value.copy(isLoading = false,
                            errorMessage = it.message.toString())
                        Log.d("log1", "error")
                    }
                    Resource.Status.LOADING -> {
                        _factFlow.value = _factFlow.value.copy(isLoading = true)
                        Log.d("log1", "loading")
                    }
                }
            }
        }
    }
}

data class BaseViewState<T>(
    val isLoading: Boolean = false,
    val data: Any? = null,
    val errorMessage: String = "",
)