package com.example.flightsearch.fragments.searchfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.example.flightsearch.viewmodels.SearchViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BottomSheetDialogFragment() {
    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args = arguments
        if (args != null) {
            val fromCity = args.getString("fromCity")
            viewModel.setFromCity(fromCity ?: "")
        }
        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    TopBar()
                    SearchScreen(viewModel, findNavController())
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.viewTreeObserver.addOnGlobalLayoutListener {
            val behavior = BottomSheetBehavior.from(view.parent as View)
            behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.97).toInt()
        }
    }
}