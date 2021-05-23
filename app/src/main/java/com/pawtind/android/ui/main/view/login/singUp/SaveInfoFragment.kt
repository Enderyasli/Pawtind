package com.pawtind.android.ui.main.view.login.singUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawtind.android.databinding.FragmentSaveInfoBinding
import com.pawtind.android.ui.base.BaseFragment

class SaveInfoFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentSaveInfoBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
}