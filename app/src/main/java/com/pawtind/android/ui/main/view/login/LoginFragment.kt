package com.pawtind.android.ui.main.view.login

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.databinding.FragmentLoginBinding
import com.pawtind.android.databinding.FragmentSignupBinding
import com.pawtind.android.ui.base.BaseFragment


class LoginFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root



        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}