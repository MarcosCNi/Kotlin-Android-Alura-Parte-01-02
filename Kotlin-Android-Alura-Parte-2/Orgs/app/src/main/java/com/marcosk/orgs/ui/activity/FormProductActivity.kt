package com.marcosk.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcosk.orgs.R
import com.marcosk.orgs.dao.ProductDao
import com.marcosk.orgs.databinding.ActivityFormProductBinding
import com.marcosk.orgs.extensions.loadImg
import com.marcosk.orgs.model.Product
import com.marcosk.orgs.ui.dialog.FormImgDialog
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity(R.layout.activity_form_product) {

    private val dao = ProductDao()
    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Produto"
        configSaveButton()
        configImgClick()
    }

    private fun configImgClick() {
        binding.formProductImg.setOnClickListener {
            FormImgDialog(this)
                .show(url) { img ->
                    url = img
                    binding.formProductImg.loadImg(url)
                }
        }
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
            productValue = BigDecimal(value),
            productImg = url

        )
    }

}