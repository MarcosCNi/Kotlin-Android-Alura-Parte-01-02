package com.marcosk.orgs.dao

import com.marcosk.orgs.model.Product
import java.math.BigDecimal

class ProductDao {

    fun add(product: Product){
        products.add(product)
    }

    fun getAll() : List<Product>{
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            Product(
                productName = "PC Gamer",
                productDesc = "Mais um pc gamer",
                productValue = BigDecimal("1999.99")
            )
        )
    }

}