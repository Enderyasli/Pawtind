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
import com.pawtind.android.ui.base.RegisterBaseFragment
import com.pawtind.android.ui.base.ViewModelFactory
import com.pawtind.android.ui.main.viewmodel.signup.LoginViewModel
import com.pawtind.android.ui.main.viewmodel.signup.WelcomeViewModel
import com.pawtind.android.utils.Constants
import com.pawtind.android.utils.PreferenceHelper
import com.pawtind.android.utils.Status
import java.lang.reflect.Field


@Suppress("NAME_SHADOWING")
class WelcomeFragment : RegisterBaseFragment<LoginViewModel>() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!


    override var useSharedViewModel = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
            getLogin()
            findNavController().navigate(R.id.action_navigation_welcome_to_navigation_login)
        }

        return view

    }

    override fun observeData() {
        super.observeData()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModelClass() = LoginViewModel::class.java


}