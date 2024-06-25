package com.example.flightsearch.fragments.tickets_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.example.flightsearch.R
import com.example.flightsearch.viewmodels.TicketsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment() {
    private val viewModel: TicketsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                TicketsScreen(viewModel)
            }
        }
    }
}