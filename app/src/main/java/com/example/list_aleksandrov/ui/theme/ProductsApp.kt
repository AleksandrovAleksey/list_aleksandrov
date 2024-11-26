package com.example.list_aleksandrov.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.list_aleksandrov.R
import com.example.list_aleksandrov.ui.theme.screens.HomeScreen

@Composable
fun ProductsApp(
    modifier: Modifier = Modifier
) {
    val productsViewModel: ProductsViewModel =
        viewModel(factory = ProductsViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize()
                topBar = { TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }) }
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            HomeScreen(productUIState = productsViewModel.productUIState)
        }
    }
}