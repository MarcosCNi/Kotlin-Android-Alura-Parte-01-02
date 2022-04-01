package com.marcosk.orgs.model

import java.math.BigDecimal

data class Product (
    val productName: String,
    val productDesc: String,
    val productValue: BigDecimal,
    val productImg: String? = null
)
