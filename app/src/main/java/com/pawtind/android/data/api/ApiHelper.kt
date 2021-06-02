package com.pawtind.android.data.api

class ApiHelper(private val apiService: ApiService) {


    fun getLogin() = apiService.getLoginPageData()
    fun getRegister() = apiService.getRegisterPageData()
    fun getRegisterDetail() = apiService.getRegisterDetailPageData()
    fun getAnimalAddPhoto() = apiService.getAnimalAddPhotoPageData()

}