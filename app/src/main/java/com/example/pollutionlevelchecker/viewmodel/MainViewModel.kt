package com.example.pollutionlevelchecker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pollutionlevelchecker.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

//    init {
//        getCurrentPollutionInfo()
//    }

    fun getCurrentPollutionInfo() {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = repository.getCurrentPollutionInfo()
                result?.response?.body?.pollutionInfoList?.let {
                    Timber.e("++++++++++++++++++${it[0].sidoName}")
                }
            }.onFailure { error ->
                Timber.e("+++++++++++++++++++++${error.message}")
            }
        }
    }
}