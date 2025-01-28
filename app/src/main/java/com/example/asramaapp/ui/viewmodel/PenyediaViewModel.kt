package com.example.asramaapp.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.asramaapp.AsramaApplications
import com.example.asramaapp.ui.viewmodel.mahasiswa.HomeMahasiswaViewModel
import com.example.asramaapp.ui.viewmodel.mahasiswa.InsertMahasiswaViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeMahasiswaViewModel(aplikasiAsrama().container.mahasiswaRepository) }
        initializer { InsertMahasiswaViewModel(aplikasiAsrama().container.mahasiswaRepository) }
    }
}

fun CreationExtras.aplikasiAsrama():AsramaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as AsramaApplications)
