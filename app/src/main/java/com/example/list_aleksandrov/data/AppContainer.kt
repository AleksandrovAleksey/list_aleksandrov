package com.example.list_aleksandrov.data

import com.example.list_aleksandrov.network.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val productsRepository: ProductsRepository
}


class DefaultAppContainer: AppContainer{
    private val BASE_URL = "https://picsum.photos"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }

    override val productsRepository: ProductsRepository by lazy {
        NetworkProductsRepository(retrofitService)
    }
}
