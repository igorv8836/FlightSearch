package com.example.flightsearch.fragments.mock_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.fragment.app.Fragment
import com.example.common.Title1


class MockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Экран заглушка",
                        style = Title1,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = com.example.common.R.color.white),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}