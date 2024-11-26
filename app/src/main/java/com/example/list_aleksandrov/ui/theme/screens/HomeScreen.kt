package com.example.list_aleksandrov.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.list_aleksandrov.data.Product
import com.example.list_aleksandrov.ui.theme.ProductUIState

@Composable
fun HomeScreen(
    productUIState: ProductUIState,
    modifier: Modifier = Modifier
) {
    when (productUIState) {
        is ProductUIState.Loading -> {
            // Показать индикатор загрузки
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        is ProductUIState.Error -> {
            // Показать сообщение об ошибке
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Text("Ошибка загрузки данных", color = Color.Red)
            }
        }
        is ProductUIState.Success -> {
            // Показать список изображений
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(productUIState.productSearch) { product ->
                    ProductItem(product = product)
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Загрузка изображения из URL
        val painter = rememberAsyncImagePainter(product.url)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}