package com.uziassantosferreira.store

import android.app.Application
import com.uziassantosferreira.store.beagle.config.BeagleSetup

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}
