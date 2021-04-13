package com.example.rentifi.property

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.rentifi.R
import com.example.rentifi.databinding.FragmentPropertyBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PropertyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PropertyFragment : Fragment() {

    private lateinit var viewModel: PropertyViewModel
    private lateinit var viewModelFactory: PropertyViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentPropertyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_property, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PropertyViewModel::class.java)
        return binding.root
    }


}