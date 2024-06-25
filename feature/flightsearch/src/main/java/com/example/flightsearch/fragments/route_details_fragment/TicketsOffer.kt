package com.example.flightsearch.fragments.route_details_fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.common.Text2
import com.example.common.Title4
import com.example.data.models.TicketsOffer
import com.example.flightsearch.utils.divideIntoThreeDigits
import com.example.flightsearch.utils.timeRangeToString

@Composable
fun TicketsOffer(ticketsOffer: TicketsOffer, color: Int) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(colorResource(id = color), shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ticketsOffer.title,
                    color = colorResource(id = com.example.common.R.color.white),
                    style = Title4,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = ticketsOffer.price.toString().divideIntoThreeDigits() + " ₽",
                    color = colorResource(id = com.example.common.R.color.blue)
                )
                Icon(
                    painter = painterResource(id = com.example.common.R.drawable.right_arrow),
                    contentDescription = null,
                    tint = colorResource(id = com.example.common.R.color.blue)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = ticketsOffer.timeRangeToString(),
                maxLines = 1,
                color = colorResource(id = com.example.common.R.color.white),
                style = Text2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}