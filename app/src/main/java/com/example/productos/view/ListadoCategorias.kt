package com.example.productos.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.productos.data.CategoriaApiService
import com.example.productos.data.CategoriaModel
import kotlinx.coroutines.launch

@Composable
fun ListadoCategorias(navController: NavHostController, servicio: CategoriaApiService) {
    // Estado para almacenar la lista de categorías
    var categorias by remember { mutableStateOf(listOf<CategoriaModel>()) }

    // LaunchedEffect se ejecuta una vez para cargar las categorías cuando se muestra la pantalla
    LaunchedEffect(Unit) {
        categorias = servicio.getCategorias() // Llama a la API para obtener las categorías
    }

    // Composición de la lista de categorías en pantalla
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categorias) { categoria ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = categoria.nombre, fontSize = 20.sp)
            }
        }
    }
}
