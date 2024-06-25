package com.example.flightsearch.fragments.tickets_fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.common.R
import com.example.common.Title3
import com.example.common.Title4
import com.example.flightsearch.fragments.tickets_fragment.ui_elements.Ticket
import com.example.flightsearch.utils.getDayFromMillis
import com.example.flightsearch.utils.getFullMonthFromMillis
import com.example.flightsearch.viewmodels.RouteDetailsViewModel

@Composable
internal fun TicketsScreen(viewModel: RouteDetailsViewModel, navController: NavController) {
    val tickets = viewModel.tickets.collectAsState()
    val ticketFilter = viewModel.ticketFilter.collectAsState()
    Box {

        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.black))
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = colorResource(id = R.color.grey_2))
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.left_arrow),
                        contentDescription = null,
                        tint = colorResource(id = R.color.blue),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

                Column {
                    Text(
                        text = "${ticketFilter.value.fromCity}-${ticketFilter.value.toCity}",
                        style = Title3,
                        color = colorResource(id = R.color.white)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${ticketFilter.value.date.getDayFromMillis()} ${ticketFilter.value.date.getFullMonthFromMillis()}, 1 пассажир",
                        style = Title4,
                        color = colorResource(id = R.color.grey_6)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tickets.value) {
                    Ticket(ticket = it)
                }
            }
        }
        Box(
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.BottomCenter)
                .offset(y = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            BottomButtons()
        }
    }
}

@Composable
fun BottomButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = colorResource(id = R.color.blue), shape = RoundedCornerShape(24.dp))
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = null,
            tint = colorResource(id = R.color.white)
        )
        Text(
            text = "Фильтр",
            style = Title4,
            color = colorResource(id = R.color.white),
            modifier = Modifier.padding(end = 16.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.graphic),
            contentDescription = null,
            tint = colorResource(id = R.color.white)
        )
        Text(
            text = "График цен",
            style = Title4,
            color = colorResource(id = R.color.white),
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}