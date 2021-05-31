package com.pawtind.android.ui.main.view.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.api.ApiServiceImpl
import com.pawtind.android.data.model.PawtindResponse
import com.pawtind.android.data.model.signup.LoginInfoMapper
import com.pawtind.android.databinding.FragmentLoginBinding
import com.pawtind.android.ui.base.BaseFragment
import com.pawtind.android.ui.base.ViewModelFactory
import com.pawtind.android.ui.main.viewmodel.signup.LoginViewModel
import com.pawtind.android.ui.main.viewmodel.signup.WelcomeViewModel
import com.pawtind.android.utils.Status
import java.lang.reflect.Field


class LoginFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupObserver()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root



        return view

    }

    private fun setupViewModel() {
        loginViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(LoginViewModel::class.java)
    }

    private fun setupObserver() {
        loginViewModel.getLogin().observe(this, Observer { it ->
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it ->


                        val pawtindResponse: List<PawtindResponse> = it.fields
                        var loginInfoMapper = LoginInfoMapper()

                        pawtindResponse.forEach { pawtindResponse: PawtindResponse ->

                            loginInfoMapper.javaClass.declaredFields.forEach {

                                if (pawtindResponse.key == it.name) {
                                    val field: Field =
                                        LoginInfoMapper::class.java.getDeclaredField(it.name)
                                    field.isAccessible = true
                                    field.set(loginInfoMapper, pawtindResponse.value)
                                }


                            }


                        }

                        binding.signupTitle.text = loginInfoMapper.title
                        binding.emailLayout.titleTv.text = loginInfoMapper.emailTitle
                        binding.emailLayout.placeholderTv.hint = loginInfoMapper.emailPlaceholder
                        binding.passwordTitleTv.text = loginInfoMapper.passwordTitle
                        binding.passwordPlaceholderTv.hint = loginInfoMapper.title
                        binding.forgotPassword.text = loginInfoMapper.forgotPasswordButtonTitle
                        binding.parentLayout.visibility= View.VISIBLE
                        binding.progressBar.visibility =View.GONE



                        Log.d("gelenresponse", it.toString())
                    }
                }
                Status.LOADING -> {
                    binding.progressBar.visibility =View.VISIBLE
                }
                Status.ERROR -> {
                    //Handle Error
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}