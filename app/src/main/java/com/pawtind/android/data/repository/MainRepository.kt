package com.pawtind.android.data.repository

import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.model.User
import com.pawtind.android.data.model.signup.Login
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getLogin(): Single<Login> {
        return apiHelper.getLogin()
    }
    fun getRegister(): Single<Login> {
        return apiHelper.getRegister()
    }
    fun getRegisterDetail(): Single<Login> {
        return apiHelper.getRegisterDetail()
    }
    fun getAnimalAddPhoto(): Single<Login> {
        return apiHelper.getAnimalAddPhoto()
    }
    fun getAnimalAdd(): Single<Login> {
        return apiHelper.getAnimalAdd()
    }

}