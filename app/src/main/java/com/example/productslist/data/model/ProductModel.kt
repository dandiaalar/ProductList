package com.example.productslist.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(val title: String, val description: String, val price: String, val thumbnail: String):Parcelable