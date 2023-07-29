package com.example.productslist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productslist.data.model.ProductModel
import com.example.productslist.domain.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

    private val _productModel = MutableLiveData<List<ProductModel>>()

    val productModel: LiveData<List<ProductModel>>
        get() = _productModel

    val isLoading = MutableLiveData<Boolean>()

    var getProductsUseCase = GetProductsUseCase()

    fun onCreate(){

        viewModelScope.launch {

            isLoading.postValue(true)

            val result = getProductsUseCase()

            if (!result.isNullOrEmpty()){
                _productModel.postValue(result)
                isLoading.postValue(false)
            }

        }
    }

}