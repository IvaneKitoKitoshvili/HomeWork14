package com.kito.homework14

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kito.homework14.RetrofitClient.getBuildingParameters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BuildingViewModel:ViewModel () {

    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState())
    val viewState = _viewState

    private fun currentViewState() = ViewState()

    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch {
            _viewState.value = (currentViewState().copy(isLoading = true))
            val result = getBuildingParameters().getItems()
            if (result.isSuccessful) {
                _viewState.value = (
                        currentViewState().copy(
                            isSuccessful = true,
                            isLoading = false,
                            list = result.body()!!
                        ))
            } else {
                _viewState.value = (
                        currentViewState().copy(
                            isSuccessful = false,
                            isLoading = false,
                            errorMsg = result.errorBody().toString()
                        ))
            }
        }
    }

    data class ViewState(
        val isSuccessful: Boolean? = null,
        val errorMsg: String? = null,
        val list: Content? = null,
        val isLoading: Boolean = false
    )
}