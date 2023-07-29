package com.example.productslist.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productslist.R
import com.example.productslist.data.model.ProductModel
import com.example.productslist.databinding.ItemProductBinding

class ProductAdapter (private val clickListener: ProductListener): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var products = listOf<ProductModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
    return ProductViewHolder.from(parent)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]
        holder.bind(item, clickListener)
    }

    class ProductViewHolder private constructor(private val binding: ItemProductBinding) :

        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ProductViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductBinding.inflate(
                    layoutInflater,
                    parent, false
                )
                return ProductViewHolder(binding)
            }
        }

        fun bind(product: ProductModel, clickListener: ProductListener){

            binding.productName.text = String.format(binding.root.context.getString(R.string.product_name), product.title)
            binding.productDescription.text = product.description
            binding.productPrice.text = String.format("$ %s", product.price)
            binding.clickListener = clickListener
            binding.product = product

        }
    }

    class ProductListener(val clickListener: (product: ProductModel) -> Unit) {
        fun onClick(product: ProductModel) = clickListener(product)
    }

}