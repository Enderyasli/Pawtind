package com.pawtind.android.ui.main.view.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.data.api.ApiHelper
import com.pawtind.android.data.api.ApiServiceImpl
import com.pawtind.android.data.model.PawtindResponse
import com.pawtind.android.data.model.signup.LoginInfoMapper
import com.pawtind.android.databinding.FragmentWelcomeBinding
import com.pawtind.android.ui.base.BaseFragment
import com.pawtind.android.ui.base.ViewModelFactory
import com.pawtind.android.ui.main.viewmodel.signup.WelcomeViewModel
import com.pawtind.android.utils.PreferenceHelper
import com.pawtind.android.utils.Status
import java.lang.reflect.Field


class WelcomeFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var welcomeViewModel: WelcomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupObserver()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root

        if (PreferenceHelper.SharedPreferencesManager.getInstance().isFirstDownload == true)
            findNavController().navigate(R.id.action_navigation_welcome_to_navigation_onboarding)

        binding.signupBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_welcome_to_navigation_signup)
        }
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_welcome_to_navigation_login)
        }

        return view

    }

    private fun setupViewModel() {
        welcomeViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(WelcomeViewModel::class.java)
    }

    private fun setupObserver() {
        welcomeViewModel.getLogin().observe(this, Observer { it ->
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it ->


                        val pawtindResponse:List<PawtindResponse> = it.fields
                        var loginInfoMapper = LoginInfoMapper()

                        pawtindResponse.forEach { pawtindResponse: PawtindResponse ->

                            loginInfoMapper.javaClass.declaredFields.forEach {


                                if(pawtindResponse.key == it.name){
                                    val field: Field = LoginInfoMapper::class.java.getDeclaredField(it.name)
                                    field.isAccessible =true
                                    field.set(loginInfoMapper,pawtindResponse.value)
                                }


                            }


                        }

                            Log.d("gelenresponse", it.toString())
                    }
                }
                Status.LOADING -> {
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