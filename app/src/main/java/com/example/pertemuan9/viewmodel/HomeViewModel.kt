package com.example.pertemuan9.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.room.Siswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIState: StateFlow<HomeUIState> = repositoriSiswa.getAllSiswaStream()
        .filterNotNull()
        .map { listSiswa ->
            HomeUIState(listSiswa.toList())
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()
        )
}

data class HomeUIState(
    val listSiswa: List<Siswa> = listOf()
)