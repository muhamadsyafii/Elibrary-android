package com.ransyadev.elibrary.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.ransyadev.elibrary.R

fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T> Fragment.openActivity(destination: Class<T>, bundleKey: String, id: String) {
    val intent = Intent(requireContext(), destination)
    intent.putExtra(bundleKey, id)
    startActivity(intent)
}

fun <T> Fragment.openActivity(destination: Class<T>) {
    val intent = Intent(requireContext(), destination)
    startActivity(intent)
}

fun <T> Activity.openActivity(destination: Class<T>, bundleKey: String, id: String) {
    val intent = Intent(this, destination)
    intent.putExtra(bundleKey, id)
    startActivity(intent)
}

fun <T> Activity.openActivity(destination: Class<T>) {
    val intent = Intent(this, destination)
    startActivity(intent)
}

fun Activity.closeActivity(){
    hideKeyboard()
    finish()
}

fun View.visible() {
    if (this.visibility == View.GONE || this.visibility == View.INVISIBLE) this.visibility =
        View.VISIBLE
}

fun View.gone() {
    if (this.visibility == View.VISIBLE) this.visibility = View.GONE
}

fun View.invisible() {
    if (this.visibility == View.VISIBLE) this.visibility = View.INVISIBLE
}

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = currentFocus
    if (view != null) {
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun View.showSnackBarInfo(
    message: String?,
    duration: Int = Snackbar.LENGTH_LONG,
) {
    val snackbar = Snackbar.make(this, message ?: "", duration)
        .setBackgroundTint(ContextCompat.getColor(this.context, R.color.alert_info_background))
        .setTextColor(ContextCompat.getColor(this.context, R.color.alert_info_text))
    val snackbarView = snackbar.view

    val textView =
        snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)

    textView.maxLines = 4

    snackbar.show()
}
