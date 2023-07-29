package com.example.productslist.ui.view

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.productslist.R
import com.example.productslist.data.model.ProductModel
import com.example.productslist.databinding.ActProductDetailBinding
import com.squareup.picasso.Picasso

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("productExtra", ProductModel::class.java)
        } else {
            intent.getParcelableExtra<ProductModel>("productExtra")
        }

        binding.detailName.text = product?.title
        binding.detailDesc.text = product?.description
        binding.detailPrice.text = String.format("$ %s", product?.price)

        Picasso.get().load(product?.thumbnail).into(binding.detailImage)

        binding.detailBack.setOnClickListener {
            finish()
        }
    }
}