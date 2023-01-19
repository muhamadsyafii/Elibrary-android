package com.ransyadev.elibrary.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.data.dummy.categoryList
import com.ransyadev.elibrary.databinding.FragmentCategoryBinding
import com.ransyadev.elibrary.ui.category.adapter.CategoryAdapter


class CategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryBinding
    private val adapter by lazy { CategoryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        adapter.submitList(categoryList)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvCategory.layoutManager = layoutManager
        binding.rvCategory.adapter = adapter
    }

}
