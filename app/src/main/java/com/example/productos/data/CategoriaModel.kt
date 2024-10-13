package com.example.productos.data

import com.google.gson.annotations.SerializedName

data class CategoriaModel(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String
)
