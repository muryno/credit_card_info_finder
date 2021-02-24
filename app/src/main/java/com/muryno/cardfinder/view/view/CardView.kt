package com.muryno.cardfinder.view.view

import com.muryno.cardfinder.model.entity.CardDetails

interface CardView{
    fun loadingFailed(msg: String)
    fun loadingSuccessful(msg: String)
    fun card (data : CardDetails?)
}