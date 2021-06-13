package com.pawtind.android.data.model

import com.google.gson.annotations.SerializedName

data class LookUpsResponse(

    @SerializedName("key")
    val key: String = "",
    @SerializedName("value")
    val value: List<PawtindResponse>

)