package com.example.productos.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.productos.data.ProductoApiService
import com.example.productos.data.ProductoModel
import kotlinx.coroutines.launch

@Composable
fun ProductoForm(navController: NavHostController, servicio: ProductoApiService, productoId: Int = 0) {
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var isEditing by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(productoId) {
        if (productoId != 0) {
            val producto = servicio.getProducto(productoId).body()
            producto?.let {
                nombre = it.nombre
                precio = it.precio.toString()
                stock = it.stock.toString()
                isEditing = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") })
        TextField(value = stock, onValueChange = { stock = it }, label = { Text("Stock") })

        Button(
            onClick = {
                coroutineScope.launch {
                    val producto = ProductoModel(productoId, nombre, precio.toDouble(), stock.toInt(), "", null, null, categoria = null)
                    if (isEditing) {
                        servicio.updateProducto(productoId, producto)
                    } else {
                        servicio.createProducto(producto)
                    }
                    navController.navigate("productos")
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = if (isEditing) "Actualizar Producto" else "Crear Producto")
        }
    }
}
