package com.pawtind.android.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawtind.android.R
import com.pawtind.android.databinding.FragmentAnimalListBinding
import com.pawtind.android.databinding.FragmentLoginBinding
import com.pawtind.android.ui.base.BaseFragment

class AnimalListFragment : BaseFragment() {

    override var bottomNavigationViewVisibility = View.GONE
    private var _binding: FragmentAnimalListBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        val view = binding.root



        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}