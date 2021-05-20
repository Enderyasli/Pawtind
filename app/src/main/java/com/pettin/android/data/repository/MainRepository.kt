package com.pettin.android.data.repository

import com.pettin.android.data.api.ApiHelper
import com.pettin.android.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}