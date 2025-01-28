package com.example.asramaapp.repository

import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.service.MahasiswaService
import java.io.IOException

interface KamarRepository {
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun updateMahasiswa(idKamar:String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(idKamar: String)
    suspend fun getMahasiswabyIdKamar(idKamar: String): Mahasiswa
}


class NetworkKamarRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> =
        mahasiswaApiService.getAllMahasiswa()


    override suspend fun updateMahasiswa(idKamar: String) {
        mahasiswaApiService.updateMahasiswa(idKamar, Mahasiswa)
    }

    override suspend fun deleteMahasiswa(idKamar: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(idKamar)
            if (!response.isSuccessful){
                throw IOException("Failed to delete kamar. HTTP Status code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }


    override suspend fun getMahasiswabyIdMahasiswa(idKamar: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswabyIdMahasiswa(idKamar)
    }

}