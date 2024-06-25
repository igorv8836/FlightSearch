package com.example.flightsearch.fragments.route_details_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flightsearch.viewmodels.RouteDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

internal class RouteDetailsFragment : Fragment() {
    private val viewModel: RouteDetailsViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var fromCity: String
        var toCity: String
        arguments?.let {
            fromCity = it.getString("fromCity") ?: ""
            toCity = it.getString("toCity") ?: ""
            viewModel.setFromCity(fromCity)
            viewModel.setToCity(toCity)
        }
        return ComposeView(requireContext()).apply {
            setContent {
                RouteDetailsScreen(viewModel = viewModel, navController = findNavController())
            }
        }
    }
}