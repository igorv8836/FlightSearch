package com.example.flightsearch.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flightsearch.R
import com.example.flightsearch.adapters.MainAdapter
import com.example.flightsearch.databinding.FragmentOffersBinding
import com.example.flightsearch.viewmodels.OffersViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class OffersFragment : Fragment() {
    private lateinit var binding: FragmentOffersBinding
    private val viewModel: OffersViewModel by viewModel()


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOffersBinding.inflate(layoutInflater, container, false)
        viewModel.getOffers()

        val adapter = MainAdapter()
        binding.offers.adapter = adapter
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.offers.layoutManager = layoutManager

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.offers.collect {
                adapter.items = it
                adapter.notifyDataSetChanged()
            }
        }

        binding.toCity.setOnClickListener {
            findNavController().navigate(R.id.toSearchFragment)
        }


        return binding.root
    }
}