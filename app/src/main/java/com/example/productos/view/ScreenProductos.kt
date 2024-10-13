package com.example.productos.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.productos.data.ProductoApiService
import com.example.productos.data.ProductoModel
import kotlinx.coroutines.launch

@Composable
fun ListadoProductos(navController: NavHostController, servicio: ProductoApiService) {
    var productos by remember { mutableStateOf(listOf<ProductoModel>()) }

    LaunchedEffect(Unit) {
        productos = servicio.getProductos()
    }

    LazyColumn {
        items(productos) { producto ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = producto.nombre, fontSize = 20.sp, modifier = Modifier.weight(0.7f))
                IconButton(onClick = {
                    navController.navigate("productoEdit/${producto.id}")
                }) {
                    Icon(Icons.Outlined.Edit, contentDescription = "Editar Producto")
                }
                IconButton(onClick = {
                    navController.navigate("productoDelete/${producto.id}")
                }) {
                    Icon(Icons.Outlined.Delete, contentDescription = "Eliminar Producto")
                }
            }
        }
    }
}

