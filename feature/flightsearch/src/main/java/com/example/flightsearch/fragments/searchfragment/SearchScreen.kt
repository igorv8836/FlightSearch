package com.example.flightsearch.fragments.searchfragment

import android.os.Bundle
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
import androidx.navigation.NavController
import com.example.common.R
import com.example.flightsearch.fragments.searchfragment.ui_elements.DestinationItem
import com.example.flightsearch.fragments.searchfragment.ui_elements.RouteElement
import com.example.flightsearch.fragments.searchfragment.ui_elements.SearchTextField
import com.example.flightsearch.viewmodels.SearchViewModel

@Composable
internal fun SearchScreen(viewModel: SearchViewModel, navController: NavController) {
    val destinations by viewModel.destinations.collectAsState()
    val fromCity by viewModel.fromCity.collectAsState()
    val text = "Куда угодно"
    val toTextFieldState = remember { mutableStateOf("") }
    val fromTextFieldState = remember { mutableStateOf(fromCity) }
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.background(
                colorResource(id = R.color.grey_2), shape = CircleShape.copy(
                    CornerSize(12.dp)
                )
            )
        ) {
            SearchTextField(
                textFieldState = fromTextFieldState,
                leadingIconId = R.drawable.plane,
                hintText = "Откуда - Москва",
                isEnabled = false,
                leadingIconTint = R.color.grey_5
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = colorResource(id = R.color.grey_4),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            SearchTextField(
                textFieldState = toTextFieldState,
                leadingIconId = R.drawable.search,
                hintText = "Куда - Турция",
                isEnabled = true,
                leadingIconTint = R.color.white
            ){
                navigateToRouteDetails(fromCity, toTextFieldState.value, navController)
            }
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
                navController.navigate(com.example.flightsearch.R.id.toMockFragment)
            }
            RouteElement(
                id = 1,
                iconId = R.drawable.ball,
                text = text,
                iconBackground = R.color.blue
            ) {
                toTextFieldState.value = text
                navigateToRouteDetails(fromCity, toTextFieldState.value, navController)
            }
            RouteElement(
                id = 2,
                iconId = R.drawable.calendar,
                text = "Выходные",
                iconBackground = R.color.dark_blue
            ) {
                navController.navigate(com.example.flightsearch.R.id.toMockFragment)
            }
            RouteElement(
                id = 3,
                iconId = R.drawable.fire,
                text = "Горячие\n билеты",
                iconBackground = R.color.red
            ) {
                navController.navigate(com.example.flightsearch.R.id.toMockFragment)
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
                    DestinationItem(it) {
                        toTextFieldState.value = it.cityName
                        navigateToRouteDetails(fromCity, toTextFieldState.value, navController)
                    }
                    HorizontalDivider(thickness = 1.dp, color = colorResource(id = R.color.grey_4))
                }
            }
        }
    }
}

fun navigateToRouteDetails(fromCity: String, toCity: String, navController: NavController){
    val bundle = Bundle()
    bundle.putString("fromCity", fromCity)
    bundle.putString("toCity", toCity)
    navController.navigate(com.example.flightsearch.R.id.toRouteDetailsFragment, bundle)
}