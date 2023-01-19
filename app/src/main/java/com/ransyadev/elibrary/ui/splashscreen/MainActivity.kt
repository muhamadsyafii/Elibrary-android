package com.ransyadev.elibrary.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.ui.home.HomeActivity
import com.ransyadev.elibrary.ui.login.LoginActivity
import com.ransyadev.elibrary.utils.db.PrefUtils
import com.ransyadev.elibrary.utils.openActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isLogin = PrefUtils.isLogin
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin){
                openActivity(HomeActivity::class.java)
            }else{
                openActivity(LoginActivity::class.java)
                finish()
            }
        },1500L)
    }
}
