package com.example.productslist.data.network

import com.example.productslist.data.model.ProductModel
import com.example.productslist.data.model.ProductProvider
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("/products")
    suspend fun getAllProducts(): Response<ProductProvider>
}