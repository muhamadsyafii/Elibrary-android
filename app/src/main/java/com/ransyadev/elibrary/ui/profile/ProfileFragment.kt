package com.ransyadev.elibrary.ui.profile

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.databinding.FragmentProfileBinding
import com.ransyadev.elibrary.ui.login.LoginActivity
import com.ransyadev.elibrary.utils.db.PrefUtils
import com.ransyadev.elibrary.utils.openActivity

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.run {
            llLogout.setOnClickListener {
                showDialogLogout()
            }
        }
    }

    private fun showDialogLogout() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Informasi")
        builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ?")
        builder.setPositiveButton("Ya") { dialog, _ ->
            dialog.dismiss()
            PrefUtils.clear()
            openActivity(LoginActivity::class.java)
        }

        builder.setNegativeButton("Tidak") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

}
