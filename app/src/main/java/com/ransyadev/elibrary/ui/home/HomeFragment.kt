package com.ransyadev.elibrary.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.data.dummy.novelList
import com.ransyadev.elibrary.databinding.FragmentHomeBinding
import com.ransyadev.elibrary.ui.detail.DetailActivity
import com.ransyadev.elibrary.ui.home.adapter.NovelAdapter
import com.ransyadev.elibrary.utils.openActivity

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val novelAdapter by lazy { NovelAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        initView()
        return binding.root
    }

    private fun initView() {
        novelAdapter.submitList(novelList)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvNovel.layoutManager = layoutManager
        binding.rvNovel.adapter = novelAdapter

        novelAdapter.onItemClick = {
            openActivity(DetailActivity::class.java)
        }
    }

}
