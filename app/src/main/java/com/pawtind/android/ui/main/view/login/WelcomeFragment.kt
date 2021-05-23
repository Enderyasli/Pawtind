package com.pawtind.android.ui.main.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.ui.base.BaseFragment


class WelcomeFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        if(false)
        findNavController().navigate(R.id.action_navigation_welcome_to_navigation_onboarding)

        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

}