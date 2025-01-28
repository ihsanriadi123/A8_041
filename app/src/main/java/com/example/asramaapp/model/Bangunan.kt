package com.example.asramaapp.model

import kotlinx.serialization.SerialName

data class Bangunan(
    @SerialName("id_bangunan")
    val idBangunan: String,
    @SerialName("nama_bangunan")
    val namaBangunan: String,
    @SerialName("jumlah_lantai")
    val jumlahLantai: String,
    val alamat: String,


    )
