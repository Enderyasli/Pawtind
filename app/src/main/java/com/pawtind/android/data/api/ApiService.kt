package com.pawtind.android.data.api

import com.pawtind.android.data.model.User
import com.pawtind.android.data.model.signup.Login
import io.reactivex.Single

interface ApiService {

    fun getLoginPageData(): Single<Login>
    fun getRegisterPageData(): Single<Login>
    fun getRegisterDetailPageData(): Single<Login>
    fun getAnimalAddPhotoPageData(): Single<Login>

}