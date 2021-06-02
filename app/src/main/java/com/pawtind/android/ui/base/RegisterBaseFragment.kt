package com.pawtind.android.ui.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.api.ApiServiceImpl
import com.pawtind.android.data.model.PawtindResponse
import com.pawtind.android.ui.main.view.MainActivity
import com.pawtind.android.ui.main.viewmodel.signup.LoginViewModel
import com.pawtind.android.utils.Status
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RegisterBaseFragment<VModel : LoginViewModel> : Fragment() {

    protected open var bottomNavigationViewVisibility = View.VISIBLE

    protected open var useSharedViewModel: Boolean = false

    protected lateinit var viewModel: VModel
    protected abstract fun getViewModelClass(): Class<VModel>

    var pawtindResponse: List<PawtindResponse>? = null
        get() = field
        set(value) {
            field = value
        }

    private val disposableContainer = CompositeDisposable()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // get the reference of the parent activity and call the setBottomNavigationVisibility method.
        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(bottomNavigationViewVisibility)

            init()
            observeData()
            setUpViews()

        }
    }

    fun getLocaizedString(key: String): String {


        pawtindResponse?.forEach {
            if (it.key == key)
                return it.value
        }

        return ""
    }

    fun setPawtindResponseList(pawtindResponseList: List<PawtindResponse>) {

        pawtindResponse = pawtindResponseList
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(bottomNavigationViewVisibility)
        }
    }

    open fun setUpViews() {}

    open fun observeView() {}

    open fun observeData() {}

    open fun getLogin() {

        viewModel.getLogin().observe(this, Observer { it ->
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let {

                        pawtindResponse = it.fields

                        Log.d("gelenresponse", it.toString())
                    }
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                }
            }
        })

    }

    private fun init() {
        viewModel = if (useSharedViewModel) {
            ViewModelProviders.of(requireActivity(), ViewModelFactory(ApiHelper(ApiServiceImpl())))
                .get(
                    getViewModelClass()
                )
        } else {
            ViewModelProvider(this).get(getViewModelClass())
        }


    }

    fun Disposable.addToContainer() = disposableContainer.add(this)

    override fun onDestroyView() {
        disposableContainer.clear()
        super.onDestroyView()
    }


}