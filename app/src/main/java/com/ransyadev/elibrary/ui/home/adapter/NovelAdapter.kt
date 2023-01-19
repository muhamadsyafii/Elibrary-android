package com.ransyadev.elibrary.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.elibrary.data.model.Novel
import com.ransyadev.elibrary.databinding.ItemNovelBinding

class NovelAdapter : ListAdapter<Novel, NovelAdapter.ViewHolder>(NovelDiffCallBack()) {

    var onItemClick : () -> Unit = {}

    inner class ViewHolder(private val binding : ItemNovelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data : Novel){
            binding.ivNovel.setImageResource(data.image)
            binding.root.setOnClickListener {
                onItemClick.invoke()
            }
        }
    }

    class NovelDiffCallBack : DiffUtil.ItemCallback<Novel>() {
        override fun areItemsTheSame(oldItem: Novel, newItem: Novel): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Novel, newItem: Novel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNovelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(getItem(position))
    }
}
