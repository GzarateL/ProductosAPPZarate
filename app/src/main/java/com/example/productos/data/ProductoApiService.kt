package com.example.productos.data

import retrofit2.Response
import retrofit2.http.*

interface ProductoApiService {

    // Obtener todos los productos
    @GET("productos/")
    suspend fun getProductos(): List<ProductoModel>

    // Obtener un solo producto
    @GET("productos/{id}/")
    suspend fun getProducto(@Path("id") id: Int): Response<ProductoModel>

    // Crear un nuevo producto
    @POST("productos/")
    suspend fun createProducto(@Body producto: ProductoModel): Response<ProductoModel>

    // Actualizar un producto existente
    @PUT("productos/{id}/")
    suspend fun updateProducto(@Path("id") id: Int, @Body producto: ProductoModel): Response<ProductoModel>

    // Eliminar un producto
    @DELETE("productos/{id}/")
    suspend fun deleteProducto(@Path("id") id: Int): Response<Void>
}
