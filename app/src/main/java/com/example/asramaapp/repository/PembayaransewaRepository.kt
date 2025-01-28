package com.example.asramaapp.repository


import com.example.asramaapp.model.Mahasiswa
import com.example.asramaapp.service.MahasiswaService
import java.io.IOException

interface PembayaransewaRepository {
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun updateMahasiswa(idPembayaranSewa: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(idPembayaranSewa: String)
    suspend fun getMahasiswabyIdPembayaransewa(idPembayaranSewa: String): Mahasiswa
}

class NetworkPembayaransewaRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> =
        mahasiswaApiService.getAllMahasiswa()


    override suspend fun updateMahasiswa(idPembayaranSewa: String) {
        mahasiswaApiService.updateMahasiswa(idPembayaranSewa, Mahasiswa)
    }

    override suspend fun deleteMahasiswa(idPembayaranSewa: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(idPembayaranSewa)
            if (!response.isSuccessful){
                throw IOException("Failed to delete pembayaransewa. HTTP Status code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        }catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswabyIdMahasiswa(idPembayaranSewa: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswabyIdMahasiswa(idPembayaranSewa)
    }

}
