package com.marcosk.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcosk.orgs.R
import com.marcosk.orgs.dao.ProductDao
import com.marcosk.orgs.databinding.ActivityFormProductBinding
import com.marcosk.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity(R.layout.activity_form_product) {

    private val dao = ProductDao()

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configSaveButton()
        setContentView(binding.root)
    }

    private fun configSaveButton() {
        val btnSave = binding.formProductBtnSave
        btnSave.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val inputName = binding.formProductName
        val name = inputName.text.toString()
        val inputDesc = binding.formProductDescription
        val desc = inputDesc.text.toString()
        val inputValue = binding.formProductValue
        val value = inputValue.text.toString()
        if (value.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(value)
        }

        return Product(
            productName = name,
            productDesc = desc,
            productValue = BigDecimal(value)
        )
    }

}