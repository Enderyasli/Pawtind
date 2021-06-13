package com.pawtind.android.data.api

import com.pawtind.android.data.model.AccessToken
import com.pawtind.android.data.model.signup.Login
import com.pawtind.android.data.model.signup.Register
import io.reactivex.Single

interface ApiService {

    fun getLoginPageData(): Single<Login>
    fun getRegisterPageData(): Single<Login>
    fun getRegisterDetailPageData(): Single<Login>
    fun getAnimalAddPhotoPageData(): Single<Login>
    fun getAnimalAddPageData(): Single<Login>
    fun postRegister(register: Register): Single<AccessToken>

}