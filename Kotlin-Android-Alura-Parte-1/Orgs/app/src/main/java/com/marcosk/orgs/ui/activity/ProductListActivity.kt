package com.marcosk.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcosk.orgs.dao.ProductDao
import com.marcosk.orgs.databinding.ActivityProductListBinding
import com.marcosk.orgs.ui.recyclerview.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity() {

    private val dao = ProductDao()
    private val adapter = ProductListAdapter(context = this, products = dao.getAll())

    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFloatingActionButton()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAll())
    }

    private fun configFloatingActionButton() {
        val fab = binding.productListFloatingActionButton
        fab.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = binding.productListRecyclerView
        recyclerView.adapter = adapter
    }

}