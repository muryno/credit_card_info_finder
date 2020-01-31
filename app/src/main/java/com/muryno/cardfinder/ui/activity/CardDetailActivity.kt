package com.muryno.cardfinder.ui.activity

import android.os.Bundle
import com.muryno.cardfinder.R
import com.muryno.cardfinder.db.CardDetails
import com.muryno.cardfinder.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : BaseActivity() {

    var cardDetails : CardDetails? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)


        if (intent != null) {
            cardDetails = intent.getSerializableExtra("data") as CardDetails
            if (cardDetails == null) {
                finish()

                //if the data is null, it should close the page, nothing to display
            }

            displayData(cardDetails)
        }

        cancl.setOnClickListener { finish() }
    }

    private fun displayData(cardDetails : CardDetails?){
        crd_brand.text = cardDetails?.brand ?: "Not available"
        crd_type.text = cardDetails?.type ?: "Not available"
        bank.text = cardDetails?.bank?.name ?: "Not available"
        country.text = cardDetails?.country?.name ?: "Not available"
        currency.text = cardDetails?.country?.currency  ?: "Not available"
    }
}
