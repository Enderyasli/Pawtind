package com.pawtind.android.ui.main.view.fragments.animal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import com.pawtind.android.databinding.FragmentAddAnimalBinding
import com.pawtind.android.databinding.FragmentSignupBinding
import com.pawtind.android.ui.base.RegisterBaseFragment
import com.pawtind.android.ui.main.viewmodel.signup.RegisterBaseViewModel
import com.pawtind.android.utils.Constants

class AddAnimalFragment : RegisterBaseFragment<RegisterBaseViewModel>() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentAddAnimalBinding? = null

    private val binding get() = _binding!!
    override var useSharedViewModel = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setUpViews() {
        super.setUpViews()

        viewModel.getAddAnimalFields().observe(this, Observer {

            setPawtindResponseList(it)


        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddAnimalBinding.inflate(inflater, container, false)
        val view = binding.root



        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModelClass() = RegisterBaseViewModel::class.java

}