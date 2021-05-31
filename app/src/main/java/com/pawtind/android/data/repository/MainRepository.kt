package com.pawtind.android.data.repository

import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.model.User
import com.pawtind.android.data.model.signup.Login
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }
    fun getLogin(): Single<Login> {
        return apiHelper.getLogin()
    }

}