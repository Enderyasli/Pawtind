package com.pawtind.android.ui.main.view.login.singUp

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
import com.pawtind.android.databinding.FragmentSignupBinding
import com.pawtind.android.databinding.FragmentWelcomeBinding
import com.pawtind.android.ui.base.BaseFragment

class SignupFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentSignupBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.signupBtn.setOnClickListener {
          findNavController().navigate(R.id.action_navigation_signup_to_navigation_photo)
        }

        val spannable = SpannableStringBuilder(getString(R.string.privacy_policy))
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            8, // start
            12, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        binding.privacyPolicyTv.text = spannable

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}