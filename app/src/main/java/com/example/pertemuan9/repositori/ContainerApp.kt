package com.example.pertemuan9.repositori

import android.app.Application
import android.content.Context
import com.example.pertemuan9.room.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa : RepositoriSiswa
}