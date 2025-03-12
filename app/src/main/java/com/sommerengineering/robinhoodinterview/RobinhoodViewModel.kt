package com.sommerengineering.robinhoodinterview

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RobinhoodViewModel : ViewModel() {

    val instruments: MutableState<List<Instrument>> = mutableStateOf(listOf())

    init {
        getInstruments()
    }

    fun getInstruments() {
        viewModelScope.launch {
            instruments.value = RobinhoodApi.retrofitService.getInstruments()
        }
    }
}