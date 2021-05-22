package com.pawtind.android.data.repository

import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}