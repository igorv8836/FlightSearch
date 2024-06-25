package com.example.flightsearch.fragments.route_details_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.fragment.findNavController
import com.example.common.Title1
import com.example.flightsearch.viewmodels.OffersViewModel
import com.example.flightsearch.viewmodels.RouteDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RouteDetailsFragment : Fragment() {
    private val viewModel: RouteDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var fromCity = ""
        var toCity = ""
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