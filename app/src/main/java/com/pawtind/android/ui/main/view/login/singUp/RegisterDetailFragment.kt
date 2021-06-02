package com.pawtind.android.ui.main.view.login.singUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.databinding.FragmentSaveInfoBinding
import com.pawtind.android.ui.base.BaseFragment
import com.pawtind.android.ui.base.RegisterBaseFragment
import com.pawtind.android.ui.main.viewmodel.signup.RegisterBaseViewModel
import com.pawtind.android.utils.Constants

class RegisterDetailFragment : RegisterBaseFragment<RegisterBaseViewModel>() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentSaveInfoBinding? = null

    override var useSharedViewModel = true

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setUpViews() {
        super.setUpViews()
        viewModel.getFields().observe(this, Observer {

            setPawtindResponseList(it)
            binding.signupTitle.text = getLocaizedString(Constants.registerTitle)
            binding.signupDescription.text =
                getLocaizedString(Constants.registerSubTitle)
            binding.dateOfBirthTv.text =
                getLocaizedString(Constants.registerDateOfBirthTitle)
            binding.genderLy.titleTv.text =
                getLocaizedString(Constants.registerEmailPlaceholder)
            binding.addAnimalBtn.text =
                getLocaizedString(Constants.registerAnimalInsertButtonTitle)
            binding.goWithoutAnimalTv.text =
                getLocaizedString(Constants.registerSkipButtonTitle)

        })

        binding.addAnimalBtn.setOnClickListener {
            fetchAnimalAddPhoto()
            findNavController().navigate(R.id.action_navigation_register_detail_to_navigation_photo)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaveInfoBinding.inflate(inflater, container, false)
        val view = binding.root


        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModelClass() = RegisterBaseViewModel::class.java

}