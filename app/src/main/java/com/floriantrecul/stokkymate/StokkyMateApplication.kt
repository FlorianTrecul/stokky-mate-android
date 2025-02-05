package com.floriantrecul.stokkymate

import android.app.Application
import com.floriantrecul.stokkymate.core.common.di.commonModule
import com.floriantrecul.stokkymate.core.navigation.apiimpl.di.navigationModule
import com.floriantrecul.stokkymate.core.logging.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class StokkyMateApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init(isDebug = BuildConfig.DEBUG, customTag = "StokkyMateApplication")

        startKoin {
            androidContext(this@StokkyMateApplication)

            modules(
                commonModule,
                navigationModule,
            )
        }
    }
}
