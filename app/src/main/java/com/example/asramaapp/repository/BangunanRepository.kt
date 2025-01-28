package com.example.asramaapp.repository


import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.service.MahasiswaService
import java.io.IOException

interface BangunanRepository {
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun updateMahasiswa(idBangunan: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(idBangunan: String)
    suspend fun getMahasiswabyIdBangunan(idBangunan: String): Mahasiswa
}

class NetworkBangunanRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> =
        mahasiswaApiService.getAllMahasiswa()


    override suspend fun updateMahasiswa(idBangunan: String) {
        mahasiswaApiService.updateMahasiswa(idBangunan, Mahasiswa)
    }


    override suspend fun deleteMahasiswa(idBangunan: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(idBangunan)
            if (!response.isSuccessful){
                throw IOException("Failed to delete bangunan. HTTP Status code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }


    override suspend fun getMahasiswabyIdMahasiswa(idBangunan: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswabyIdMahasiswa(idBangunan)
    }

}
