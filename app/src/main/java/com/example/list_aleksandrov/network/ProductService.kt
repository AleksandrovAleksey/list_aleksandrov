package com.example.list_aleksandrov.network

import com.example.list_aleksandrov.data.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("v2/list")
    suspend fun getImageList(): List<Product>
}