package com.muryno.cardfinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muryno.cardfinder.db.CardDetails
import com.muryno.cardfinder.ui.repository.CardRepository
import com.muryno.cardfinder.ui.view.CardView

class MainViewModel : ViewModel(), CardView {

    var presenter: CardRepository = CardRepository()



    //get success message from the server

    var _sucessfful= MutableLiveData<String>()


    //get error message from the server
    var _error= MutableLiveData<String>()




    //get card details  from the server
    var _card= MutableLiveData<CardDetails>()


    //send card to server
    fun postData(card_num : String){
        presenter.getCardDetails(card_num,this)
    }

    override fun loadingFailed(msg: String) {
        _error.postValue(msg)
    }

    override fun loadingSuccessful(msg: String) {
        _sucessfful.postValue(msg)
    }

    override fun card(data: CardDetails?) {
        _card.postValue(data)
    }


}