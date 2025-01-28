package com.example.asramaapp.service

import com.example.asramaapp.model.Mahasiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface KamarService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
    )

    @POST("insertmahasiswa.php")
    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa)

    @GET("bacamahasiswa.php")
    suspend fun getAllMahasiswa(): List<Mahasiswa>

    @GET("baca1mahasiswa.php/{id_kamar}")
    suspend fun getMahasiswabyIdKamar(@Query("id_kamar") idKamar:String):Mahasiswa

    @PUT("editmahasiswa.php/{id_kamar}")
    suspend fun updateMahasiswa(@Query("id_mahasiswa") idKamar:String, @Body mahasiswa: Mahasiswa)

    @DELETE("deletemahasiswa.php/{id_kamar}")
    suspend fun deleteMahasiswa(@Query("id_kamar") idKamar:String): Response<Void>
}