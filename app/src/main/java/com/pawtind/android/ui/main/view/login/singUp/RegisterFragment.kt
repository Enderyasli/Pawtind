package com.pawtind.android.ui.main.view.login.singUp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.data.model.signup.Register
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

    @SuppressLint("SetTextI18n")
    override fun setUpViews() {
        super.setUpViews()

        viewModel.getRegisterFields().observe(this, {

            setPawtindResponseList(it)
            binding.signupTitle.text = getLocalizedString(Constants.registerTitle)
            binding.signupDescription.text = getLocalizedString(Constants.registerSubTitle)

            binding.nameLy.titleTv.text =
                getLocalizedString(Constants.registerNameTitle)
            binding.nameLy.placeholderTv.hint =
                getLocalizedString(Constants.registerNamePlaceholder)
            binding.surnameLy.titleTv.text =
                getLocalizedString(Constants.registerSurnameTitle)
            binding.surnameLy.placeholderTv.hint =
                getLocalizedString(Constants.registerSurnamePlaceholder)
            binding.emailTitleTv.text =
                getLocalizedString(Constants.registerEmailTitle)
            binding.emailPlaceholderTv.hint =
                getLocalizedString(Constants.registerEmailPlaceholder)
            binding.passwordTitleTv.text =
                getLocalizedString(Constants.registerPasswordTitle)
            binding.passwordDetailTv.text =
                getLocalizedString(Constants.registerPasswordDetail)
            binding.passwordPlaceholderTv.hint =
                getLocalizedString(Constants.registerPasswordPlaceholder)
            binding.signupBtn.text =
                getLocalizedString(Constants.registerButtonTitle)
            binding.termsLinkTitleTv.text =
                getLocalizedString(Constants.registerTermsLinkTitle) + " "
            binding.termsAndTitleTv.text =
                getLocalizedString(Constants.registerTermsAndTitle) + " "
            binding.privacyTitleTv.text =
                getLocalizedString(Constants.registerPrivacyLinkTitle) + " "
            binding.privacyApproveTitleTv.text =
                getLocalizedString(Constants.registerPrivacyApproveTitle)

            binding.termsLinkTitleTv.setOnClickListener {
                val uri: Uri =
                    Uri.parse(getLocalizedString(Constants.registerTermsLink))
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            binding.privacyTitleTv.setOnClickListener {
                val uri: Uri =
                    Uri.parse(getLocalizedString(Constants.registerPrivacyLink))
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

            var valid = true
//            if (TextUtils.isEmpty(binding.nameLy.placeholderTv.text.trim())) {
//                binding.nameLy.placeholderTv.error = "Name cannot be empty"
//                valid = false
//            }

            if (valid) {
                postRegister(
                    Register(
                        binding.emailPlaceholderTv.text.toString().trim(),
                        "Ender",
                        "Yaşlı",
                        "testparola"
                    )
                )
                fetchRegisterDetail()
                findNavController().navigate(R.id.action_navigation_signup_to_navigation_register_detail)

            }

        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModelClass() = RegisterBaseViewModel::class.java

}