package com.example.productslist.data

import com.example.productslist.data.model.ProductModel
import com.example.productslist.data.network.ProductService

class ProductRepository {
    private val api = ProductService()

    suspend fun getAllProducts():List<ProductModel>{ // corrutina
        return api.getProducts().products // llamo al backend -> recupero los productos
    }
}