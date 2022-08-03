package com.kito.homework14

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuildingViewModel : ViewModel() {

    val viewState: MutableLiveData<ViewState> = MutableLiveData()

    private fun currentViewState(): ViewState = viewState.value!!

    init {
        viewState.value = ViewState()
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.getDeliveryService().getItems()
            if (response.isSuccessful) {
                viewState.postValue(
                    currentViewState().copy(
                        isSuccessful = true,
                        itemData = response.body()
                    )
                )
            } else {
                viewState.postValue(
                    currentViewState().copy(
                        isSuccessful = true,
                        error = response.errorBody().toString()
                    )
                )
            }
        }
    }

    data class ViewState(
        val itemData: BuildingModel? = null,
        val error: String? = null,
        val isSuccessful: Boolean? = null
    )
}
