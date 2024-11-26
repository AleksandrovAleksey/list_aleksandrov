package com.example.list_aleksandrov.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.list_aleksandrov.ui.theme.ProductUIState

@Composable
fun HomeScreen(
    productUIState: ProductUIState,
    modifier: Modifier = Modifier,
) {
    when (productUIState){
        is ProductUIState.Success -> ProductGridScreen(
            products = productUIState.productSearch,
            modifier = modifier,
        )

        ProductUIState.Error -> TODO()
        ProductUIState.Loading -> TODO()
    }
}