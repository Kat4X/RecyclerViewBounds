package com.kat4x.boundsrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kat4x.boundsrecyclerview.databinding.ItemRecyclerBinding

class PageBackgroundAdapter : RecyclerView.Adapter<PageBackgroundAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tv.text = "Item ${position+ 1 }"
        }
    }

    override fun getItemCount() = differ.currentList.size
}
