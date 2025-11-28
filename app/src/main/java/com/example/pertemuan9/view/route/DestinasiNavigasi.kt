package com.example.pertemuan9.view.route

interface DestinasiNavigasi {
    /**
     * Nama unik untuk menentukan jalur untuk compossable
     */
    val route: String

    /**
     * String resource id yang berisi judul yang akan ditampilkan di layar halaman.
     */
    val titleRes: Int
}