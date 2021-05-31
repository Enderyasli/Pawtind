package com.pawtind.android.data.api

import com.pawtind.android.data.model.User
import com.pawtind.android.data.model.signup.Login
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getUsers(): Single<List<User>> {
        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getObjectListSingle(User::class.java)
    }

    override fun getLogin(): Single<Login> {
        return Rx2AndroidNetworking.get("http://api.pawtind.com/api/page/login/info")
            .build()
            .getObjectSingle(Login::class.java)
    }

}