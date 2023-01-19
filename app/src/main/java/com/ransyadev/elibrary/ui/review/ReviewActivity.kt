package com.ransyadev.elibrary.ui.review

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ransyadev.elibrary.data.dummy.reviewList
import com.ransyadev.elibrary.databinding.ActivityReviewBinding
import com.ransyadev.elibrary.ui.review.adapter.ReviewAdapter

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReviewBinding
    private val reviewAdapter by lazy { ReviewAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener{finish()}
        reviewAdapter.submitList(reviewList)
        val layoutManager = LinearLayoutManager(this@ReviewActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvReview.layoutManager = layoutManager
        binding.rvReview.adapter = reviewAdapter
    }
}
