package com.example.flightsearch.fragments.route_details_fragment.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common.Text1

@Composable
internal fun SubscribeElement(priceSubscription: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(
                color = colorResource(id = com.example.common.R.color.grey_2),
                shape = CircleShape.copy(
                    CornerSize(8.dp)
                )
            )
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = com.example.common.R.drawable.subscription),
            contentDescription = null,
            tint = colorResource(id = com.example.common.R.color.blue),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "Подписка на цену",
            style = Text1,
            color = colorResource(id = com.example.common.R.color.white),
            modifier = Modifier.weight(1f)
        )
        CustomSwitch(checked = priceSubscription.value, onCheckedChange = { priceSubscription.value = it })
    }
}