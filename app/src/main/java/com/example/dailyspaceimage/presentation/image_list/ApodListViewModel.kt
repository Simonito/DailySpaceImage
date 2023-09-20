package com.example.dailyspaceimage.presentation.image_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dailyspaceimage.ApodApplication
import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.common.Resource
import com.example.dailyspaceimage.domain.use_case.get_apods.GetApodsUC
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

class ApodListViewModel(
    private val getApodsUC: GetApodsUC,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val savedStateHandle: SavedStateHandle
    private val _state = mutableStateOf(ApodListState())
    val state: State<ApodListState> = _state

    init {
        this.savedStateHandle = savedStateHandle
        val startDate = savedStateHandle.get<LocalDate>(Constants.PARAM_START_DATE)
        val endDate = savedStateHandle.get<LocalDate>(Constants.PARAM_END_DATE)
        if (startDate != null && endDate != null) {
            getApods(startDate = startDate, endDate = endDate)
        }
    }

    fun currentDate(date: LocalDate) {
        this.savedStateHandle.set(Constants.PARAM_DATE, date)
    }

    private fun getApods(startDate: LocalDate, endDate: LocalDate) {
        getApodsUC(startDate, endDate).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = ApodListState(apods = resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ApodListState(
                        error = resource.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = ApodListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getApodsUC = GetApodsUC(ApodApplication.appModule.apodRepository)
                val savedStateHandle = ApodApplication.appModule.apodDateStateHandle
                ApodListViewModel(getApodsUC = getApodsUC, savedStateHandle = savedStateHandle)
            }
        }
    }
}
