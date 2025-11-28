package com.example.pertemuan9.viewmodel.provider

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.viewmodel.EntryViewModel
import com.example.pertemuan9.viewmodel.HomeViewModel

/**
 * Menyediakan objek factory untuk setiap ViewModel
 */
object PenyediaViewModel {
    val Factory = viewModelFactory {
        // Inisialisasi HomeViewModel
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // Inisialisasi EntryViewModel
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah
 * instance dari [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)