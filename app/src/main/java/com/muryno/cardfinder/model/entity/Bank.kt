package com.muryno.cardfinder.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Bank :Serializable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var    url: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null

}