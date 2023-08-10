package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.domain.model.NasaModel
import com.keepcoding.androidsuperpoderes.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel() {

    private val _nasa = MutableLiveData<NasaModel>()
    val nasa: LiveData<NasaModel> get() = _nasa

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun getNasa(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _nasa.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}
