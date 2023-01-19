package com.ransyadev.elibrary

import android.app.Application

class ElibraryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: ElibraryApp
            private set
    }

}
