package com.muryno.cardfinder.ui.view

import com.muryno.cardfinder.db.CardDetails

interface CardView{
    fun loadingFailed(msg: String)
    fun loadingSuccessful(msg: String)
    fun card (data : CardDetails?)
}