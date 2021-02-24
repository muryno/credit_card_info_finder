package com.muryno.cardfinder.view.activity

import android.content.Intent
import android.os.Bundle
import com.muryno.cardfinder.view.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
    }
}
