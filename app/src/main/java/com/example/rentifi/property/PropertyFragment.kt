package com.example.rentifi.property

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rentifi.R
import com.example.rentifi.database.RentFiDatabase
import com.example.rentifi.databinding.FragmentPropertyBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PropertyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PropertyFragment : Fragment() {

    private lateinit var viewModel: PropertyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentPropertyBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_property, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = RentFiDatabase.getInstance(application).propertyDao
        val arguments = PropertyFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(
            this,
            PropertyViewModelFactory(arguments.property, dataSource, application)
        ).get(PropertyViewModel::class.java)

        binding.propertyViewModel = viewModel
        return binding.root
    }


}