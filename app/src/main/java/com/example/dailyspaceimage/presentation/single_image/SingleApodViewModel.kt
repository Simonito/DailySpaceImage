package com.example.dailyspaceimage.presentation.single_image

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.common.Resource
import com.example.dailyspaceimage.domain.use_case.get_single_apod.GetSingleApodUC
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

class SingleApodViewModel(
    private val getLatestApodUC: GetSingleApodUC,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SingleApodState())
    val state: State<SingleApodState> = _state

    init {
        savedStateHandle.get<LocalDate>(Constants.PARAM_END_DATE)?. let { endDate ->
            getApod(endDate)
        }
    }

    private fun getApod(endDate: LocalDate) {
        getLatestApodUC(endDate).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = SingleApodState(apod = resource.data)
                }
                is Resource.Error -> {
                    _state.value = SingleApodState(
                        error = resource.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = SingleApodState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
