package com.example.list_aleksandrov.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.list_aleksandrov.ProductApplication
import com.example.list_aleksandrov.data.Product
import com.example.list_aleksandrov.data.ProductsRepository
import kotlinx.coroutines.launch
import retrofit2.http.HTTP
import java.io.IOException


sealed interface ProductUIState{
    data class Success(val productSearch: List<Product>) : ProductUIState
    object Error: ProductUIState
    object Loading: ProductUIState
}


class ProductsViewModel(
    private val productsRepository: ProductsRepository
):ViewModel() {

    var productUIState: ProductUIState by mutableStateOf(ProductUIState.Loading)
        private set

    init {
        getImages()
    }

    fun getImages(){
        viewModelScope.launch {
            productUIState = ProductUIState.Loading
            productUIState = try {
                ProductUIState.Success(productsRepository.getImages())
            }
            catch (e: IOException){
                ProductUIState.Error
            }
            catch (e: HttpException){
                ProductUIState.Error
            }
        }
    }

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ProductApplication)
                val productsRepository = application.container.productsRepository
                ProductsViewModel(productsRepository = productsRepository)
            }
        }
    }

}