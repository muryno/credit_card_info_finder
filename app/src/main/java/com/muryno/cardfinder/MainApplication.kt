package com.muryno.cardfinder

import androidx.multidex.MultiDexApplication
import java.util.concurrent.Executors

class MainApplication : MultiDexApplication() {
    override fun onCreate() { super.onCreate()
        instance = this
    }

    companion object {
        val executorService =
            Executors.newCachedThreadPool()
        var instance: MainApplication? = null
            private set

    }
}