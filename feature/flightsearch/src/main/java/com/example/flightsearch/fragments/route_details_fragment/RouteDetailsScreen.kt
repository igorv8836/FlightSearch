package com.example.flightsearch.fragments.route_details_fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.common.ButtonText1
import com.example.common.Title2
import com.example.flightsearch.R
import com.example.flightsearch.fragments.route_details_fragment.ui_elements.FilterElement
import com.example.flightsearch.fragments.route_details_fragment.ui_elements.RouteDetailsTextField
import com.example.flightsearch.fragments.route_details_fragment.ui_elements.SubscribeElement
import com.example.flightsearch.fragments.route_details_fragment.ui_elements.TicketsOffer
import com.example.flightsearch.fragments.route_details_fragment.ui_elements.showDatePickerDialog
import com.example.flightsearch.utils.getDayFromMillis
import com.example.flightsearch.utils.getMonthFromMillis
import com.example.flightsearch.utils.getWeekDayFromMillis
import com.example.flightsearch.viewmodels.RouteDetailsViewModel
import kotlin.math.min

@Composable
internal fun RouteDetailsScreen(viewModel: RouteDetailsViewModel, navController: NavController) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val ticketFilter by viewModel.ticketFilter.collectAsState()
    val ticketsOffer by viewModel.ticketsOffer.collectAsState()
    val toTextFieldState = remember(ticketFilter) { mutableStateOf(ticketFilter.toCity) }
    val fromTextFieldState = remember(ticketFilter) { mutableStateOf(ticketFilter.fromCity) }
    val priceSubscription = remember { mutableStateOf(false) }
    val colors = listOf(
        com.example.common.R.color.red,
        com.example.common.R.color.blue,
        com.example.common.R.color.white
    )
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(top = 48.dp).background(colorResource(id = com.example.common.R.color.black))
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .background(
                    colorResource(id = com.example.common.R.color.grey_3), shape = CircleShape.copy(
                        CornerSize(12.dp)
                    )
                )
        ) {
            Icon(
                painter = painterResource(id = com.example.common.R.drawable.left_arrow),
                tint = colorResource(id = com.example.common.R.color.white),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
                    .clickable(
                        onClick = { navController.popBackStack() },
                        interactionSource = interactionSource,
                        indication = rememberRipple(bounded = false, radius = 24.dp)
                    )
            )
            Column {
                RouteDetailsTextField(
                    textFieldState = fromTextFieldState,
                    trailingIconId = com.example.common.R.drawable.change,
                    hintText = "Откуда - Москва",
                    isEnabled = false,
                    trailingIconTint = com.example.common.R.color.white
                ) {
                    viewModel.setToCity(ticketFilter.fromCity)
                    viewModel.setFromCity(ticketFilter.toCity)
                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = colorResource(id = com.example.common.R.color.grey_4),
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                RouteDetailsTextField(
                    textFieldState = toTextFieldState,
                    trailingIconId = com.example.common.R.drawable.close,
                    hintText = "Куда - Турция",
                    isEnabled = false,
                    trailingIconTint = com.example.common.R.color.grey_6
                ) {
                    navController.navigateUp()
                }
            }
        }

        Row(
            modifier = Modifier
                .horizontalScroll(state = scrollState)
                .padding(start = 16.dp, top = 12.dp),
        ) {
            if (ticketFilter.returnDate != null) {
                FilterElement(
                    text = "${ticketFilter.returnDate!!.getDayFromMillis()} ${ticketFilter.returnDate!!.getMonthFromMillis()}",
                    addingText = ", ${ticketFilter.returnDate!!.getWeekDayFromMillis()}"
                ) {
                    showDatePickerDialog(context) {
                        viewModel.setReturnDate(it)
                    }
                }
            } else {
                FilterElement(
                    leadingIconId = com.example.common.R.drawable.plus,
                    leadingIconTint = com.example.common.R.color.white,
                    text = "обратно"
                ) {
                    showDatePickerDialog(context) {
                        viewModel.setReturnDate(it)
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            FilterElement(
                text = "${ticketFilter.date.getDayFromMillis()} ${ticketFilter.date.getMonthFromMillis()}",
                addingText = ", ${ticketFilter.date.getWeekDayFromMillis()}"
            ) {
                showDatePickerDialog(context) {
                    viewModel.setDate(it)
                }

            }
            Spacer(modifier = Modifier.width(8.dp))
            FilterElement(
                leadingIconId = com.example.common.R.drawable.people,
                leadingIconTint = com.example.common.R.color.grey_5,
                text = "1, эконом"
            )
            Spacer(modifier = Modifier.width(8.dp))
            FilterElement(
                leadingIconId = com.example.common.R.drawable.filter,
                leadingIconTint = com.example.common.R.color.white,
                text = "фильтры"
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(
                    colorResource(id = com.example.common.R.color.grey_1), shape = CircleShape.copy(
                        CornerSize(12.dp)
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Прямые рейсы",
                style = Title2,
                color = colorResource(id = com.example.common.R.color.white),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyColumn {
                items(min(ticketsOffer.size, 3)) {
                    TicketsOffer(ticketsOffer[it], colors[it])
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = colorResource(id = com.example.common.R.color.grey_4)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(R.id.toTicketsFragment) },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = com.example.common.R.color.blue))
        ) {
            Text(
                text = "Посмотреть все билеты",
                style = ButtonText1,
                color = colorResource(id = com.example.common.R.color.white)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        SubscribeElement(priceSubscription = priceSubscription)
    }
}