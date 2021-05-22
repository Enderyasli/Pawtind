package com.pawtind.android.ui.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.pawtind.android.R
import kotlinx.android.synthetic.main.fragment_favorite.*


/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view:View=   inflater.inflate(R.layout.fragment_favorite, container, false)
        // Inflate the layout for this fragment
       val favorite_txt = view.findViewById(R.id.favorite_txt) as TextView
            favorite_txt.setOnClickListener {

                val someFragment: Fragment = test()
                val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
                transaction.replace(
                    R.id.navHostFragment,
                    someFragment
                ) // give your fragment container id in first parameter

                transaction.addToBackStack(null) // if written, this transaction will be added to backstack

                transaction.commit()
            }
        return view
    }

}