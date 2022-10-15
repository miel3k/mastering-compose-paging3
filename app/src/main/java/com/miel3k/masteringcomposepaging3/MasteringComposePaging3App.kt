package com.miel3k.masteringcomposepaging3

import android.app.Application
import com.miel3k.masteringcomposepaging3.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by jmielczarek on 14/10/2022
 */
class MasteringComposePaging3App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MasteringComposePaging3App)
            modules(koinModules)
        }
    }
}