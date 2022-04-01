package com.marcosk.orgs.dao

import com.marcosk.orgs.model.Product

class ProductDao {

    fun add(product: Product){
        products.add(product)
    }

    fun getAll() : List<Product>{
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }

}