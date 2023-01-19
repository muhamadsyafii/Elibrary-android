package com.ransyadev.elibrary.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.widget.doAfterTextChanged
import com.ransyadev.elibrary.databinding.ActivityLoginBinding
import com.ransyadev.elibrary.ui.home.HomeActivity
import com.ransyadev.elibrary.ui.register.RegisterActivity
import com.ransyadev.elibrary.utils.FIELD_REQUIRED
import com.ransyadev.elibrary.utils.db.PrefUtils
import com.ransyadev.elibrary.utils.hideKeyboard
import com.ransyadev.elibrary.utils.openActivity
import com.ransyadev.elibrary.utils.showSnackBarInfo
import com.ransyadev.elibrary.utils.showToast

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private var isExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.run {
            tvRegister.setOnClickListener {
                openActivity(RegisterActivity::class.java)
            }
            checkAfterChange()
            btnAction.setOnClickListener {
                hideKeyboard()
                if (checkValidate()){
                    PrefUtils.isLogin = true
                    scrollView.showSnackBarInfo("Selamat Datang ${etUsername.text}")
                    Handler(Looper.getMainLooper()).postDelayed({
                        openActivity(HomeActivity::class.java)
                    }, 500)
                }
            }


        }
    }

    private fun checkAfterChange() {
        binding.run {
            etUsername.doAfterTextChanged {
                if (etUsername.error != null) {
                    etUsername.error = null
                }
            }
            etPassword.doAfterTextChanged {
                if (etPassword.error != null) {
                    etPassword.error = null
                }
            }
        }
    }


    private fun checkValidate(): Boolean {
        var isValid = true
        binding.run {
            if (etUsername.text.toString().isEmpty()) {
                etUsername.error = FIELD_REQUIRED
                isValid = false
            }
            if (etPassword.text.toString().isEmpty()) {
                etPassword.error = FIELD_REQUIRED
                isValid = false
            }
        }
        return isValid
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
