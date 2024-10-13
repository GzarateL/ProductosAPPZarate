package com.example.productos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.productos.ui.theme.ProductosTheme
import com.example.productos.data.ProductoApiService
import com.example.productos.data.CategoriaApiService
import com.example.productos.view.SeriesApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar Retrofit para conectar con tu API Django
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.6:8000/tienda/") // URL base de tu API Django con prefijo 'tienda/'
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Crear instancias de los servicios de Producto y Categoría
        val productoApiService = retrofit.create(ProductoApiService::class.java)
        val categoriaApiService = retrofit.create(CategoriaApiService::class.java)

        // Establecer el contenido con Jetpack Compose
        setContent {
            ProductosTheme {
                // Recordar el controlador de navegación
                val navController = rememberNavController()

                // Llamar a SeriesApp para gestionar la navegación y las pantallas
                SeriesApp(
                    navController = navController,
                    productoApiService = productoApiService,
                    categoriaApiService = categoriaApiService
                )
            }
        }
    }
}

