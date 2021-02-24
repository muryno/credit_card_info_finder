package com.muryno.cardfinder.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CardDetails : Serializable {

    @SerializedName("number")
    @Expose
    var number: Number? = null
    @SerializedName("scheme")
    @Expose
    var    scheme: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("brand")
    @Expose
    var brand: String? = null
    @SerializedName("country")
    @Expose
    var country: Country? = null
    @SerializedName("bank")
    @Expose
    var bank: Bank? = null

}