package com.ransyadev.elibrary.ui.review.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.elibrary.data.model.Review
import com.ransyadev.elibrary.databinding.ItemReviewBinding

class ReviewAdapter : ListAdapter<Review, ReviewAdapter.ViewHolder>(ReviewDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class ViewHolder (private val binding : ItemReviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(data : Review){
            binding.run {
                ivMessage.setImageResource(data.image)
                tvTitle.text = data.title
                rbReview.rating = data.review.toFloat()
            }
        }
    }

    class ReviewDiffCallBack : DiffUtil.ItemCallback<Review>(){
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }

    }
}
