package com.pawtind.android.ui.main.view.login.singUp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.databinding.FragmentSignupBinding
import com.pawtind.android.ui.base.RegisterBaseFragment
import com.pawtind.android.ui.main.viewmodel.signup.RegisterBaseViewModel
import com.pawtind.android.utils.Constants


class RegisterFragment : RegisterBaseFragment<RegisterBaseViewModel>() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentSignupBinding? = null

    private val binding get() = _binding!!
    override var useSharedViewModel = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setUpViews() {
        super.setUpViews()

        viewModel.getFields().observe(this, Observer {

            setPawtindResponseList(it)
            binding.signupTitle.text = getLocaizedString(Constants.registerTitle)
            binding.signupDescription.text = getLocaizedString(Constants.registerSubTitle)

            binding.nameLy.titleTv.text =
                getLocaizedString(Constants.registerNameTitle)
            binding.nameLy.placeholderTv.hint =
                getLocaizedString(Constants.registerNamePlaceholder)
            binding.surnameLy.titleTv.text =
                getLocaizedString(Constants.registerSurnameTitle)
            binding.surnameLy.placeholderTv.hint =
                getLocaizedString(Constants.registerSurnamePlaceholder)
            binding.emailLy.titleTv.text =
                getLocaizedString(Constants.registerEmailTitle)
            binding.emailLy.placeholderTv.hint =
                getLocaizedString(Constants.registerEmailPlaceholder)
            binding.passwordTitleTv.text =
                getLocaizedString(Constants.registerPasswordTitle)
            binding.passwordDetailTv.text =
                getLocaizedString(Constants.registerPasswordDetail)
            binding.passwordPlaceholderTv.hint =
                getLocaizedString(Constants.registerPasswordPlaceholder)
            binding.signupBtn.text =
                getLocaizedString(Constants.registerButtonTitle)
            binding.termsLinkTitleTv.text =
                getLocaizedString(Constants.registerTermsLinkTitle) + " "
            binding.termsAndTitleTv.text =
                getLocaizedString(Constants.registerTermsAndTitle) + " "
            binding.privacyTitleTv.text =
                getLocaizedString(Constants.registerPrivacyLinkTitle) + " "
            binding.privacyApproveTitleTv.text =
                getLocaizedString(Constants.registerPrivacyApproveTitle)

            binding.termsLinkTitleTv.setOnClickListener {
                val uri: Uri =
                    Uri.parse(getLocaizedString(Constants.registerTermsLink))
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            binding.privacyTitleTv.setOnClickListener {
                val uri: Uri =
                    Uri.parse(getLocaizedString(Constants.registerPrivacyLink))
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }


        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.signupBtn.setOnClickListener {
            fetchRegisterDetail()
            findNavController().navigate(R.id.action_navigation_signup_to_navigation_register_detail)
        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModelClass() = RegisterBaseViewModel::class.java

}