package com.muryno.cardfinder.db

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Number: Serializable {
    @SerializedName("length")
    @Expose
    var length: Int? = null
    @SerializedName("luhn")
    @Expose
    var luhn: Boolean? = null
}