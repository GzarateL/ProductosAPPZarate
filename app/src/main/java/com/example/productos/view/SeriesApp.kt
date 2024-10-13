package com.example.productos.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.productos.data.ProductoApiService
import com.example.productos.data.CategoriaApiService

@Composable
fun SeriesApp(
    navController: NavHostController,
    productoApiService: ProductoApiService,
    categoriaApiService: CategoriaApiService // Asegúrate de que estás pasando el servicio correctamente
) {
    NavHost(navController = navController, startDestination = "productos") {
        composable("productos") {
            ListadoProductos(navController, productoApiService)
        }
        composable("productoNuevo") {
            ProductoForm(navController, productoApiService)
        }
        composable(
            "productoEdit/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val productoId = it.arguments?.getInt("id") ?: 0
            ProductoForm(navController, productoApiService, productoId)
        }
        composable(
            "productoDelete/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val productoId = it.arguments?.getInt("id") ?: 0
            EliminarProducto(navController, productoApiService, productoId)
        }
        composable("categorias") {
            ListadoCategorias(navController, categoriaApiService)
        }
    }
}
