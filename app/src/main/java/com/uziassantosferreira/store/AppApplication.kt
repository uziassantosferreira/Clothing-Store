package com.uziassantosferreira.store

import android.app.Application
import com.uziassantosferreira.store.beagle.BeagleSetup

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}
