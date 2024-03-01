package com.lutfi.quiz3.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lutfi.quiz3.data.response.ApiResponseItem
import com.lutfi.quiz3.databinding.ItemRvBinding

class ItemAdapter(private val listItem: List<ApiResponseItem?>): RecyclerView.Adapter<ItemAdapter.ListViewHolder>(){

    class ListViewHolder(var binding: ItemRvBinding, val context: Context) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listItem[position]
        with(holder.binding) {
            titleTextView.text = item?.title
            Glide.with(holder.context)
                .load(item?.url)
                .into(image)
        }
    }
}