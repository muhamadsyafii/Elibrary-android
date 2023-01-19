package com.ransyadev.elibrary.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ransyadev.elibrary.databinding.ActivityDetailBinding
import com.ransyadev.elibrary.ui.review.ReviewActivity
import com.ransyadev.elibrary.utils.openActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.run {
            ivBack.setOnClickListener { finish() }
            btnPinjam.setOnClickListener {
                if (isLoading){
                    isLoading = false
                    btnPinjam.text = "Loading"
                }else{
                    isLoading = true
                    btnPinjam.text = "Pinjam"
                }
            }
            btnUlasan.setOnClickListener {
                openActivity(ReviewActivity::class.java)
            }
        }
    }
}
