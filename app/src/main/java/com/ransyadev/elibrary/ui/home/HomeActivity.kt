package com.ransyadev.elibrary.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.databinding.ActivityHomeBinding
import com.ransyadev.elibrary.ui.category.CategoryFragment
import com.ransyadev.elibrary.ui.profile.ProfileFragment
import com.ransyadev.elibrary.utils.gone
import com.ransyadev.elibrary.utils.hideKeyboard
import com.ransyadev.elibrary.utils.showToast
import com.ransyadev.elibrary.utils.visible

class HomeActivity : AppCompatActivity() , NavigationBarView.OnItemSelectedListener{
    private lateinit var binding : ActivityHomeBinding
    private var isExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        hideKeyboard()
        binding.bottomNavigation.setOnItemSelectedListener(this)
        selectActiveTabs(binding.bottomNavigation.selectedItemId)

        binding.sivProfile.setOnClickListener {
            binding.bottomNavigation.selectedItemId = R.id.nav_profile
            selectActiveTabs(R.id.nav_profile)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectActiveTabs(itemId = item.itemId)
        return true
    }

    private fun selectActiveTabs(itemId: Int) {
        when(itemId){
            R.id.nav_category -> {
                loadFragment(fragment = CategoryFragment())
                binding.clToolbar.gone()
            }
            R.id.nav_profile -> {
                loadFragment(fragment = ProfileFragment())
                binding.clToolbar.gone()
            }
            R.id.nav_home -> {
                loadFragment(fragment = HomeFragment())
                binding.clToolbar.visible()
            }
        }
    }

    private fun loadFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        if (isExit) {
            super.onBackPressed()
            finishAffinity()
        } else {
            isExit = true
            showToast("Press once again to close the app..")
        }
        Handler(Looper.getMainLooper()).postDelayed({ isExit = false }, 2000)
    }
}
