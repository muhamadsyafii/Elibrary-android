package com.ransyadev.elibrary.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.google.android.material.button.MaterialButton
import com.ransyadev.elibrary.R

object DialogUtils {

    fun showDialogSuccess(context: Context, onClick : () -> Unit = {}){
        val builder = Dialog(context)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setContentView(R.layout.dialog_success_register)
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val btnSuccess = builder.findViewById<MaterialButton>(R.id.btn_action)
        btnSuccess.setOnClickListener {
            builder.dismiss()
           onClick.invoke()
        }
        builder.show()
    }
}
