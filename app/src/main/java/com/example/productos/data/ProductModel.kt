package com.example.productos.data

import com.google.gson.annotations.SerializedName

data class ProductoModel(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("precio") val precio: Double,
    @SerializedName("stock") val stock: Int,
    @SerializedName("pub_date") val pubDate: String,
    @SerializedName("imagen") val imagen: String?,
    @SerializedName("imagen_url") val imagenUrl: String?,
    @SerializedName("categoria") val categoria: CategoriaModel
)

data class CategoriaModel(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String
)