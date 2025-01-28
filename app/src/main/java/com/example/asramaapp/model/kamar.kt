package com.example.asramaapp.model

import kotlinx.serialization.SerialName

data class kamar(
    @SerialName("id_kamar")
    val idKamar: String,
    @SerialName("nomor_kamar")
    val nomorKamar: String,
    @SerialName("id_bangunan")
    val idBangunan: String,
    val email: String,
    val kapasitas: String,
    @SerialName("status_kamar")
    val statusKamar: String,
)

