package com.pawtind.android.data.api

import com.pawtind.android.data.model.User
import com.pawtind.android.data.model.signup.Login
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>
    fun getLogin(): Single<Login>

}