package com.example.rentifi.property

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.rentifi.R
import com.example.rentifi.database.RentFiDatabase
import com.example.rentifi.databinding.FragmentAddPropertyBinding

class AddPropertyFragment : Fragment() {

    private lateinit var binding: FragmentAddPropertyBinding
    private lateinit var viewModel: AddPropertyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_property, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = RentFiDatabase.getInstance(application).propertyDao
        viewModel = ViewModelProvider(this, AddPropertyViewModelFactory(dataSource, application)).get()

        binding.lifecycleOwner = this
        binding.addPropertyViewModel = viewModel

        assignListeners()

        return binding.root
    }

    private fun assignListeners() {
        binding.saveButton.setOnClickListener { view: View -> onSave() }
    }

    fun onSave() {
        val propertyTitle = binding.titleInput.text.toString()
        val propertyAddress = binding.addressInput.text.toString()
        viewModel.onSave(propertyTitle, propertyAddress)
    }

}