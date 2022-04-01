package com.marcosk.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcosk.orgs.databinding.ActivityProductItemBinding
import com.marcosk.orgs.extensions.loadImg
import com.marcosk.orgs.model.Product
import java.text.NumberFormat
import java.util.*

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

    class ViewHolder(private val binding: ActivityProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binding(product: Product) {
            val name = binding.productItemName
            name.text = product.productName
            val desc = binding.productItemDescription
            desc.text = product.productDesc
            val valPtBr: String = formatValPtBr(product)
            val value = binding.productItemValue
            value.text = valPtBr

            val visibility = if (product.productImg != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.productItemImg.visibility = visibility

            binding.productItemImg.loadImg(product.productImg)
        }

        private fun formatValPtBr(product: Product): String {
            val cashFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return cashFormat.format(product.productValue)
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
