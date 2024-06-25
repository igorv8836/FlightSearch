package com.example.flightsearch.fragments.tickets_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flightsearch.viewmodels.RouteDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

internal class TicketsFragment : Fragment() {
    private val viewModel: RouteDetailsViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getTickets()
        return ComposeView(requireContext()).apply {
            setContent {
                TicketsScreen(viewModel, findNavController())
            }
        }
    }
}