package com.example.list_aleksandrov.data

import com.example.list_aleksandrov.network.ProductService

interface ProductsRepository {
    suspend fun getImages():List<Product>
}

class NetworkProductsRepository(
    private val productService: ProductService
): ProductsRepository{
    override suspend fun getImages(): List<Product> = productService.getImageList()
}