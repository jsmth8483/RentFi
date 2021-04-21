package com.example.rentifi.home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rentifi.R
import com.example.rentifi.database.RentFiDatabase
import com.example.rentifi.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application
        val dataSource = RentFiDatabase.getInstance(application).propertyDao
        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(dataSource, application)
        ).get(HomeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        val adapter = PropertyItemAdapter { property ->
            property.let {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPropertyFragment(it)
                )
            }
        }
        binding.propertyList.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add_property -> {
                navigateToAddProperty()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun navigateToAddProperty() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddPropertyFragment())
    }

}