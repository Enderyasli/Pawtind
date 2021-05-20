package com.pettin.android.data.api

import com.pettin.android.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}