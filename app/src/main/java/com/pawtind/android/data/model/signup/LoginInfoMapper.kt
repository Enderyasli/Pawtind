package com.pawtind.android.data.model.signup

import com.google.gson.annotations.SerializedName

data class LoginInfoMapper(

    @SerializedName("emailPlaceholder")
    var emailPlaceholder: String = "",
    @SerializedName("emailTitle")
    val emailTitle: String = "",
    @SerializedName("forgotPasswordButtonTitle")
    val forgotPasswordButtonTitle: String = "",
    @SerializedName("loginButtonTitle")
    val loginButtonTitle: String = "",
    @SerializedName("passwordPlaceholder")
    val passwordPlaceholder: String = "",
    @SerializedName("passwordTitle")
    val passwordTitle: String = "",
    @SerializedName("title")
    val title: String = "",


    )