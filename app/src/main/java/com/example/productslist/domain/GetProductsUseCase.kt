package com.example.productslist.domain

import com.example.productslist.data.ProductRepository
import com.example.productslist.data.model.ProductModel

class GetProductsUseCase {
    private val repository = ProductRepository()

    suspend operator fun invoke():List<ProductModel> = repository.getAllProducts()
}