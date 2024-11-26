package com.example.list_aleksandrov.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.list_aleksandrov.R
import com.example.list_aleksandrov.ui.theme.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsApp(
    modifier: Modifier = Modifier
) {
    // Убедитесь, что импортируется androidx.lifecycle.viewmodel.compose.viewModel
    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeScreen(productUIState = productsViewModel.productUIState)
        }
    }
}