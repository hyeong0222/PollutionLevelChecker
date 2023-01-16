package com.example.pollutionlevelchecker.ui

import com.example.pollutionlevelchecker.model.PollutionInfo

data class MainViewState(
    val loading: Boolean = false,
    val refreshing: Boolean = false,
    val error: Throwable? = null,

    val pollutionInfo: PollutionInfo = PollutionInfo()
) {
    companion object {
        fun from(pollutionInfo: PollutionInfo) {

        }
    }
}