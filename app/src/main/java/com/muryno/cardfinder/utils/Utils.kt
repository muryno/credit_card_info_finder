package com.muryno.cardfinder.utils

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.text.Editable
import com.muryno.cardfinder.MainApplication
import com.muryno.cardfinder.R
import java.util.*


@TargetApi(Build.VERSION_CODES.M)
fun isOnline(): Boolean {

    if ( MainApplication.getInstance()?.applicationContext == null)
        return false

    val cm = MainApplication.getInstance()?.applicationContext
        ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager



    val activeNetwork = cm.activeNetwork
    return activeNetwork != null
}

fun greetings() :String? {
    val c = Calendar.getInstance()

    val earlmorning = "Dear you should be on bed"
    val morning2 = "Wake up dear.. good morning"
    val morning3 = "Beautiful morning"
    val evening = "Good afternoon"
    val day = "Guess your day is going on fine"
    val night = "Almost time for bed..how is the evening"
    when (c.get(Calendar.HOUR_OF_DAY)) {
        in 0..5 -> {
            return earlmorning
        }
        in 6..7 -> {
            return morning2
        }
        in 8..11 -> {
            return morning3
        }

        in 12..16 -> {
            return evening
        }

        in 17..20 -> {
            return day
        }

        in 21..23 -> {
            return night
        }


    }
    return ""
}


fun getGreetingIcon() :Int? {

    val c = Calendar.getInstance()

    when (c.get(Calendar.HOUR_OF_DAY)) {
        in 0..5 -> {
            return R.drawable.ic_sleepy
        }
        in 6..7 -> {
            return R.drawable.ic_wake_up
        }
        in 8..11 -> {
            return R.drawable.ic_sun
        }

        in 12..16 -> {
            return R.drawable.ic_afternoon
        }

        in 17..20 -> {
            return R.drawable.ic_happy
        }

        in 21..23 -> {
            return R.drawable.ic_cloudy_night
        }
    }
return 0

}

//m
fun getCartLogo(s: Editable): Int{

    when (s.substring(0, 1).toInt()) {
        4 -> {
            return R.drawable.ic_visa
        }
        5 -> {
            return  R.drawable.ic_mastercard
        }
        6 -> {
            return  R.drawable.ic_discover
        }
        3 -> {
            return  R.drawable.ic_amex
        }
        else -> {
            return  R.drawable.ic_warning
        }
    }
}

fun setCardNumber(s: Editable){
    val space = ' '

    var pos = 0
    while (true) {
        if (pos >= s.length) break
        if (space == s[pos] && ((pos + 1) % 5 != 0 || pos + 1 == s.length)) {
            s.delete(pos, pos + 1)
        } else {
            pos++
        }
    }
    // Insert char where needed.
    pos = 4
    while (true) {
        if (pos >= s.length) break
        val c = s[pos]
        // Only if its a digit where there should be a space we insert a space
        if ("0123456789".indexOf(c) >= 0) {
            s.insert(pos, "" + space)
        }
        pos += 5
    }
}
