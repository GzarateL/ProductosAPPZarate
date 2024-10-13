package com.example.productos.view

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.productos.data.ProductoApiService
import kotlinx.coroutines.launch

@Composable
fun EliminarProducto(navController: NavHostController, servicio: ProductoApiService, productoId: Int) {
    var confirmacionVisible by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    if (confirmacionVisible) {
        AlertDialog(
            onDismissRequest = { confirmacionVisible = false },
            title = { Text("Confirmar eliminación") },
            text = { Text("¿Estás seguro de que deseas eliminar este producto?") },
            confirmButton = {
                Button(onClick = {
                    coroutineScope.launch {
                        servicio.deleteProducto(productoId)
                        navController.navigate("productos")
                    }
                    confirmacionVisible = false
                }) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                Button(onClick = { confirmacionVisible = false }) {
                    Text("Cancelar")
                    navController.navigate("productos")
                }
            }
        )
    }
}
