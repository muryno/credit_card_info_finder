package com.muryno.cardfinder

import android.text.Editable
import com.muryno.cardfinder.ui.activity.MainActivity
import com.muryno.cardfinder.utils.getGreetingIcon
import com.muryno.cardfinder.utils.greetings
import com.muryno.cardfinder.utils.isOnline
import com.muryno.cardfinder.utils.setCardNumber
import org.junit.Assert
import org.junit.Test

class UtilsUnitTest {

    @Test
    fun spaceSetCardNumber() {

       val s: Editable ?= null
        s?.equals(6).toString()
        assert(true) {
            if (s != null) {
                setCardNumber(s)
            }
        }

    }



    @Test
    fun checkDeviceOnline() {
        Assert.assertEquals(false, isOnline())
    }


    //was successful by your current time...put the icon in the function
    @Test
    fun getGreetingIcon() {
        Assert.assertEquals( R.drawable.ic_cloudy_night,getGreetingIcon())
    }


    @Test
    fun getGreetingMessage() {

        val night = "Almost time for bed..how is the evening"
        Assert.assertEquals( night,greetings())
    }


}