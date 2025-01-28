package com.example.asramaapp.repository

import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.service.MahasiswaService
import java.io.IOException

interface MahasiswaRepository {
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun updateMahasiswa(idMahasiswa: String)
    suspend fun deleteMahasiswa(idMahasiswa: String)
    suspend fun getMahasiswabyIdMahasiswa(idMahasiswa: String): Mahasiswa
}


class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> =
        mahasiswaApiService.getAllMahasiswa()


    override suspend fun updateMahasiswa(idMahasiswa: String) {
        mahasiswaApiService.updateMahasiswa(idMahasiswa, Mahasiswa)
    }

    override suspend fun deleteMahasiswa(idMahasiswa: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(idMahasiswa)
            if (!response.isSuccessful){
                throw IOException("Failed to delete mahasiswa. HTTP Status code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswabyIdMahasiswa(idMahasiswa: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswabyIdMahasiswa(idMahasiswa)
    }

}