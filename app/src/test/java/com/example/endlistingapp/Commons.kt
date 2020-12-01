package com.example.endlistingapp

import com.example.endlistingapp.model.ListingModel
import com.example.endlistingapp.model.Products

val prod1 = Products(10, "product1", "100", "imgUrl")
val prod2 = Products(20, "product2", "200", "imgUrl")
val prod3 = Products(30, "product3", "300", "imgUrl")
val productList = mutableListOf(prod1, prod2, prod3)
val listingModel = ListingModel(productList, "Listing Title", 3)