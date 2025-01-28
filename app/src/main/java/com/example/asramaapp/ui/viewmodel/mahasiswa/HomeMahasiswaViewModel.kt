package com.example.asramaapp.ui.viewmodel.mahasiswa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import okio.IOException

sealed class HomeUiState{
    data class Succes(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}

class HomeMahasiswaViewModel(private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch {
            mhsUIState= HomeUiState.Loading
            mhsUIState=try {
                HomeUiState.Succes(mhs.getMahasiswa())
            }catch (e:IOException){
                HomeUiState.Error
            }catch (e:HttpException){
                HomeUiState.Error
            }
        }
    }

    fun deleteMhs(idMahasiswa: String){
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(idMahasiswa)
            }catch (e:IOException){
                HomeUiState.Error
            }catch (e:HttpException){
                HomeUiState.Error
            }
        }
    }
}