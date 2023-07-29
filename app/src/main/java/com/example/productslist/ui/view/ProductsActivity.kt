package com.example.productslist.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productslist.data.model.ProductModel
import com.example.productslist.databinding.ActProductsBinding
import com.example.productslist.ui.viewmodel.ProductViewModel

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActProductsBinding

    private val productViewModel : ProductViewModel by viewModels()

    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel.onCreate()
        initRecycler()

        productViewModel.productModel.observe(this, Observer {products ->

            adapter.products = products

        })

        productViewModel.isLoading.observe(this, Observer {
            binding.productsProgress.isVisible = it
        })

    }

    private fun initRecycler() {
        adapter = ProductAdapter(ProductAdapter.ProductListener { product ->
            startActivity(Intent(this@ProductsActivity, ProductDetailActivity::class.java).apply {
                putExtra("productExtra", product)
            })
        })
        binding.productsRecycler.layoutManager = LinearLayoutManager(this)
        binding.productsRecycler.adapter = adapter


    }
}