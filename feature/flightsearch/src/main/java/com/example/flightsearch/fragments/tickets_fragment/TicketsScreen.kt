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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.common.R
import com.example.common.Text2
import com.example.common.Title1
import com.example.common.Title3
import com.example.common.Title4
import com.example.data.models.Ticket
import com.example.flightsearch.utils.divideIntoThreeDigits
import com.example.flightsearch.utils.getArrivalTime
import com.example.flightsearch.utils.getDepartureTime
import com.example.flightsearch.utils.getDuration
import com.example.flightsearch.viewmodels.TicketsViewModel

@Composable
fun TicketsScreen(viewModel: TicketsViewModel) {
    val tickets = viewModel.tickets.collectAsState()
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = colorResource(id = R.color.grey_2))
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.left_arrow),
                contentDescription = null,
                tint = colorResource(id = R.color.blue),
                modifier = Modifier.padding(end = 8.dp)
            )
            Column {
                Text(text = "Москва", style = Title3, color = colorResource(id = R.color.white))
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "23 февраля, 1 пассажир",
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
}

@Composable
fun Ticket(ticket: Ticket) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.grey_1),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = ticket.price.toString().divideIntoThreeDigits() + " ₽",
                style = Title1,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.padding(end = 4.dp)
                        .background(
                            color = colorResource(id = R.color.red),
                            shape = CircleShape
                        )
                        .size(24.dp)
                )
                Column {
                    Text(
                        text = ticket.getDepartureTime(),
                        style = Title4,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = ticket.departure.airport,
                        style = Title4,
                        color = colorResource(id = R.color.grey_6)
                    )
                }

                HorizontalDivider(
                    thickness = 1.dp,
                    color = colorResource(id = R.color.grey_6),
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 8.dp).width(10.dp).align(Alignment.Top)
                )
                Column {
                    Text(
                        text = ticket.getArrivalTime(),
                        style = Title4,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = ticket.arrival.airport,
                        style = Title4,
                        color = colorResource(id = R.color.grey_6)
                    )
                }
                Text(
                    text = ticket.getDuration() + "ч в пути",
                    style = Text2,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.align(Alignment.Top).padding(start = 12.dp)
                )
                if (ticket.hasTransfer) {
                    Text(
                        text = " / ",
                        style = Text2,
                        color = colorResource(id = R.color.grey_6),
                        modifier = Modifier.align(Alignment.Top)
                    )
                    Text(
                        text = "Без пересадок",
                        style = Text2,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.align(Alignment.Top)
                    )
                }
            }
        }
        ticket.badge?.let {
            Box(
                modifier = Modifier
                    .zIndex(1f)
                    .offset(y = -(12.dp))
                    .align(Alignment.TopStart)
            ) {
                TicketIndicator(text = it)
            }
        }
    }

}