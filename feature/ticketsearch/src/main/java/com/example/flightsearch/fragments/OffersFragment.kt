package com.example.flightsearch.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flightsearch.adapters.MainAdapter
import com.example.flightsearch.viewmodels.OffersViewModel
import com.example.ticketsearch.R
import com.example.ticketsearch.databinding.FragmentOffersBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class OffersFragment : Fragment() {
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.lastCity.collect {
                it?.let { city ->
                    binding.fromCity.setText(city)
                }
            }
        }

        binding.toCity.setOnClickListener {
            val fromCity = binding.fromCity.text.toString()
            if (fromCity.isEmpty()) {
                Toast.makeText(requireContext(), "Название города не может быть пустым", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.saveLastCity(fromCity)
            val bundle = Bundle()
            bundle.putString("fromCity", fromCity)
            findNavController().navigate(R.id.toSearchFragment, bundle)
        }


        return binding.root
    }
}