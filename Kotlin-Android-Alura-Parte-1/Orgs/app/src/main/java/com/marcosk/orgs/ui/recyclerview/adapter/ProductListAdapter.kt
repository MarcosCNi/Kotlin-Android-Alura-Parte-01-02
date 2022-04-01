package com.marcosk.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcosk.orgs.databinding.ActivityProductItemBinding
import com.marcosk.orgs.model.Product

class ProductListAdapter(
        private val context: Context,
        products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityProductItemBinding
            .inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    class ViewHolder(binding: ActivityProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val name = binding.productItemName
        private val desc = binding.productItemDescription
        private val value = binding.productItemValue

        fun binding(product: Product) {
            name.text = product.productName
            desc.text = product.productDesc
            value.text = product.productValue.toPlainString()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.binding(product)
    }

    override fun getItemCount(): Int = products.size
    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
