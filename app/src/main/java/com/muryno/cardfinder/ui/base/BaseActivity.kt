package com.muryno.cardfinder.ui.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.muryno.cardfinder.MainApplication
import com.muryno.cardfinder.R
import com.muryno.cardfinder.utils.isOnline
import es.dmoral.toasty.Toasty

//this is unique and to be use by all activity with same properties
abstract class BaseActivity: AppCompatActivity() {
    internal var snackbar: Snackbar? = null
    @Volatile
    private var isOn = false
    internal var view: View? = null

    fun setToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }


    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        view = getView()
        if (view != null) {

            //if internet is off it display a buttom snack
            snackbar = Snackbar.make(view!!, "Check your internet connection.", Snackbar.LENGTH_INDEFINITE)
            val snackBarView = snackbar!!.view
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            val textView= snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.gravity = View.TEXT_ALIGNMENT_CENTER
            textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    private fun getView(): View? {
        val vg = findViewById<ViewGroup>(android.R.id.content)
        var rv: View? = null

        if (vg != null)
            rv = vg.getChildAt(0)
        if (rv == null)
            rv = window.decorView.rootView
        return rv
    }




    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item!!)
    }


    protected fun snackBar(message: String) {
        if (view != null) {
            Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).show()
        }
    }


    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
        super.onPause()
        isOn = false
    }

    override fun onResume() {
        super.onResume()
        registerInternetCheckReceiver()
        isOn = true
    }




    private fun registerInternetCheckReceiver() {
        val internetFilter = IntentFilter()
        internetFilter.addAction("android.net.wifi.STATE_CHANGE")
        internetFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(broadcastReceiver, internetFilter)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (isOnline()) {
                snackbar?.dismiss()
            } else {
                snackbar?.show()
            }
        }
    }

    protected fun toastSuccess(msg: String) {
        MainApplication.getInstance()?.applicationContext?.let {
            Toasty.success(it, msg, Toast.LENGTH_SHORT, true).show() }
    }

    protected fun toastError(msg: String) {
        MainApplication.getInstance()?.applicationContext?.let { Toasty.error(it, msg, Toast.LENGTH_SHORT, true).show() }
    }

    protected fun toastInfo(msg: String) {
        MainApplication.getInstance()?.applicationContext?.let { Toasty.info(it, msg, Toast.LENGTH_SHORT, true).show() }
    }

    protected fun toastWarning(msg: String) {
        MainApplication.getInstance()?.applicationContext?.let { Toasty.warning(it, msg, Toast.LENGTH_SHORT, true).show() }
    }

}