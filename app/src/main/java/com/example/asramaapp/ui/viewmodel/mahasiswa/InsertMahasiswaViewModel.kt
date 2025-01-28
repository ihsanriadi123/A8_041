package com.example.asramaapp.ui.viewmodel.mahasiswa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class InsertMahasiswaViewModel(private val mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertMhsState(insertUiEvent: InsertUiEvent){
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertMhs(){
        viewModelScope.launch {
            try {
                mhs.insertMahasiswa(uiState.insertUiEvent.toMhs())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

data class InsertUiEvent(
    val idMahasiswa: String = "",
    val namaMahasiswa: String = "",
    val nomorIdentitas: String = "",
    val nomorTelepon: String = "",
    val idKamar: String = "",
    val email: String = "",
)

fun InsertUiEvent.toMhs(): Mahasiswa = Mahasiswa(
    idMahasiswa = idMahasiswa,
    namaMahasiswa = namaMahasiswa,
    email = email,
    idKamar = idKamar,
    nomorTelepon = nomorTelepon,
    nomorIdentitas = nomorIdentitas
)

fun Mahasiswa.toUiStateMhs(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)

fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    idMahasiswa = idMahasiswa,
    namaMahasiswa = namaMahasiswa,
    email = email,
    idKamar = idKamar,
    nomorTelepon = nomorTelepon,
    nomorIdentitas = nomorIdentitas
)