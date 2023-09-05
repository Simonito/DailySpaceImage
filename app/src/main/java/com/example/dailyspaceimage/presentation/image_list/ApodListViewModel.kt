package com.example.dailyspaceimage.presentation.image_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _state = mutableStateOf(ApodListState())
    val state: State<ApodListState> = _state

    init {
        val startDate = savedStateHandle.get<LocalDate>(Constants.PARAM_START_DATE)
        val endDate = savedStateHandle.get<LocalDate>(Constants.PARAM_END_DATE)
        if (startDate != null && endDate != null) {
            getApods(startDate = startDate, endDate = endDate)
        }
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
}
