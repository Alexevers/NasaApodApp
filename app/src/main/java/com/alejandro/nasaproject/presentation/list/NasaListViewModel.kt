package com.alejandro.nasaproject.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.nasaproject.domain.model.NasaModel
import com.alejandro.nasaproject.domain.usecase.GetNasaListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NasaListViewModel(
    private val getNasaListUseCase: GetNasaListUseCase
) : ViewModel() {

    private val _nasaList = MutableLiveData<List<NasaModel>>()
    val nasaList: LiveData<List<NasaModel>> get() = _nasaList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage



    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //examples.exampleFold()
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getNasaListUseCase.invoke()
                }
                _nasaList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }
}
