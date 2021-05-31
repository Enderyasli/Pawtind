package com.pawtind.android.ui.main.viewmodel.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pawtind.android.data.model.signup.Login
import com.pawtind.android.data.repository.MainRepository
import com.pawtind.android.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val login = MutableLiveData<Resource<Login>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchLogin()
    }


    private fun fetchLogin() {
        login.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getLogin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    login.postValue(Resource.success(userList))
                }, {
                    login.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getLogin(): LiveData<Resource<Login>> {
        return login
    }

}