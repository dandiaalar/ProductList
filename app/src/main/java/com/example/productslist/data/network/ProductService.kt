package com.example.productslist.data.network

import com.example.productslist.core.RetrofitHelper
import com.example.productslist.data.model.ProductModel
import com.example.productslist.data.model.ProductProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(): ProductProvider {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ProductApiClient::class.java).getAllProducts()
            response.body() ?: ProductProvider(emptyList())
        }
    }

}