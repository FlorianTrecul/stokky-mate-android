package com.floriantrecul.stokkymate

import android.app.Application
import com.floriantrecul.stokkymate.core.logging.Logger

class StokkyMateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init(isDebug = BuildConfig.DEBUG, customTag = "StokkyMateApplication")
    }

}
