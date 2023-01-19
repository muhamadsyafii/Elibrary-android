package com.ransyadev.elibrary.ui.register

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.ransyadev.elibrary.databinding.ActivityRegisterBinding
import com.ransyadev.elibrary.utils.DialogUtils
import com.ransyadev.elibrary.utils.FIELD_REQUIRED
import com.ransyadev.elibrary.utils.hideKeyboard
import com.ransyadev.elibrary.utils.showSnackBarInfo

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.run {
            checkAfterChange()
            btnAction.setOnClickListener {
                hideKeyboard()
                if (checkValidate()) {
                    DialogUtils.showDialogSuccess(this@RegisterActivity, onClick = {
                        finish()
                    })
                }
            }
        }
    }

    private fun checkAfterChange() {
        binding.run {
            etFullName.doAfterTextChanged {
                if (etFullName.error != null) {
                    etFullName.error = null
                }
            }
            etUsername.doAfterTextChanged {
                if (etUsername.error != null) {
                    etUsername.error = null
                }
            }
            etEmail.doAfterTextChanged {
                if (etEmail.error != null) {
                    etEmail.error = null
                }
            }
            etPassword.doAfterTextChanged {
                if (etPassword.error != null) {
                    etPassword.error = null
                }
            }
            etRePassword.doAfterTextChanged {
                if (etRePassword.error != null) {
                    etRePassword.error = null
                }
            }
        }
    }


    private fun checkValidate(): Boolean {
        var isValid = true
        binding.run {
            if (etFullName.text.toString().isEmpty()) {
                etFullName.error = FIELD_REQUIRED
                isValid = false
            }
            if (etUsername.text.toString().isEmpty()) {
                etUsername.error = FIELD_REQUIRED
                isValid = false
            }
            if (etEmail.text.toString().isEmpty()) {
                etEmail.error = FIELD_REQUIRED
                isValid = false
            }
            if (etPassword.text.toString().isEmpty()) {
                etPassword.error = FIELD_REQUIRED
                isValid = false
            }
            if (etRePassword.text.toString().isEmpty()) {
                etRePassword.error = FIELD_REQUIRED
                isValid = false
            }
        }
        return isValid
    }
}
