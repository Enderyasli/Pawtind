package com.pawtind.android.ui.main.viewmodel.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pawtind.android.data.model.PawtindResponse
import com.pawtind.android.data.model.signup.Login
import com.pawtind.android.data.repository.MainRepository
import com.pawtind.android.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RegisterBaseViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val login = MutableLiveData<Resource<Login>>()
    private val register = MutableLiveData<Resource<Login>>()
    private val fields = MutableLiveData<List<PawtindResponse>>()
    private val compositeDisposable = CompositeDisposable()


    public fun fetchLogin() {
        login.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getLogin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ loginData ->
                    login.postValue(Resource.success(loginData))
                    fields.postValue(loginData.fields)
                }, {
                    login.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }
    public fun fetchRegister() {
        register.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getRegister()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ registerData ->
                    register.postValue(Resource.success(registerData))
                    fields.postValue(registerData.fields)
                }, {
                    register.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    public fun fetchRegisterDetail() {
        register.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getRegisterDetail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ registerData ->
                    register.postValue(Resource.success(registerData))
                    fields.postValue(registerData.fields)
                }, {
                    register.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    public fun fetchAnimalAddPhoto() {
        register.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getAnimalAddPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ registerData ->
                    register.postValue(Resource.success(registerData))
                    fields.postValue(registerData.fields)
                }, {
                    register.postValue(Resource.error("Something Went Wrong", null))
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

    fun setFields(pawtindResponse: List<PawtindResponse>) {
        fields.value = pawtindResponse
    }

    fun getFields(): LiveData<List<PawtindResponse>> {
        return fields
    }

}