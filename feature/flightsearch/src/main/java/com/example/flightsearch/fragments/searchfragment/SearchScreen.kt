package com.example.flightsearch.fragments.searchfragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.flightsearch.viewmodels.SearchViewModel

@Composable
internal fun SearchScreen(viewModel: SearchViewModel) {
    val destinations by viewModel.destinations.collectAsState()
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.background(
                colorResource(id = R.color.grey_3), shape = CircleShape.copy(
                    CornerSize(12.dp)
                )
            )
        ) {
            val toTextFieldState = remember { mutableStateOf("") }
            val fromTextFieldState = remember { mutableStateOf("") }
            MyTextField(
                textFieldState = toTextFieldState,
                iconId = R.drawable.plane,
                hintText = "Откуда - Москва",
                isEnabledClearButton = false,
                leadingIconTint = R.color.grey_5
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = colorResource(id = R.color.grey_4),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            MyTextField(
                textFieldState = fromTextFieldState,
                iconId = R.drawable.search,
                hintText = "Куда - Турция",
                isEnabledClearButton = true,
                leadingIconTint = R.color.white
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            RouteElement(
                id = 0,
                iconId = R.drawable.route,
                text = "Сложный\n маршрут",
                iconBackground = R.color.green
            ) {

            }
            RouteElement(
                id = 1,
                iconId = R.drawable.ball,
                text = "Куда угодно",
                iconBackground = R.color.blue
            ) {

            }
            RouteElement(
                id = 2,
                iconId = R.drawable.calendar,
                text = "Выходные",
                iconBackground = R.color.dark_blue
            ) {

            }
            RouteElement(
                id = 3,
                iconId = R.drawable.fire,
                text = "Горячие\n билеты",
                iconBackground = R.color.red
            ) {

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.grey_3), shape = CircleShape.copy(
                        CornerSize(12.dp)
                    )
                )
        ) {
            LazyColumn(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            ) {
                items(destinations) {
                    DestinationItem(it) {}
                    HorizontalDivider(thickness = 1.dp, color = colorResource(id = R.color.grey_4))
                }
            }
        }
    }
}