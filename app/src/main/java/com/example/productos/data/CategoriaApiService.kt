package com.example.productos.data

import retrofit2.Response
import retrofit2.http.*

interface CategoriaApiService {

    // Obtener todas las categorías
    @GET("categorias/")
    suspend fun getCategorias(): List<CategoriaModel>

    // Obtener una categoría por ID
    @GET("categorias/{id}/")
    suspend fun getCategoria(@Path("id") id: Int): Response<CategoriaModel>
}