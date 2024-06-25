package com.example.flightsearch.fragments.mock_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.common.Title1


internal class MockFragment : Fragment() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    color = colorResource(id = com.example.common.R.color.black),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Mock Fragment",
                                    color = colorResource(id = com.example.common.R.color.white)
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors()
                                .copy(containerColor = colorResource(id = com.example.common.R.color.grey_2)),
                            navigationIcon = {
                                IconButton(onClick = {
                                    findNavController().navigateUp()
                                }) {
                                    Icon(
                                        painter = painterResource(id = com.example.common.R.drawable.left_arrow),
                                        tint = colorResource(id = com.example.common.R.color.white),
                                        contentDescription = "Назад"
                                    )
                                }
                            }
                        )
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Экран заглушка",
                                style = Title1,
                                color = colorResource(id = com.example.common.R.color.white),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}