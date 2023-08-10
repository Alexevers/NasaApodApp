package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel
import com.keepcoding.androidsuperpoderes.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel() {

    private val _hero = MutableLiveData<HeroModel>()
    val hero: LiveData<HeroModel> get() = _hero

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun getHero(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _hero.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}
