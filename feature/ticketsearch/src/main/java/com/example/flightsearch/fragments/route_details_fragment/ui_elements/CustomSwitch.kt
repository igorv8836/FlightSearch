package com.example.flightsearch.fragments.route_details_fragment.ui_elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
internal fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val switchColor by animateColorAsState(
        if (checked)
            colorResource(id = com.example.common.R.color.blue).copy(alpha = 0.5f)
        else
            colorResource(id = com.example.common.R.color.grey_5),
        label = ""
    )
    val thumbColor by animateColorAsState(
        if (checked)
            colorResource(id = com.example.common.R.color.blue)
        else
            colorResource(id = com.example.common.R.color.white),
        label = ""
    )
    val thumbOffset by animateDpAsState(if (checked) 14.dp else 0.dp, label = "")

    Box(
        modifier = Modifier
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = interactionSource,
                indication = null
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .width(34.dp)
                .height(14.dp)
                .background(switchColor, shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 2.dp, vertical = 3.dp),
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .offset(x = thumbOffset)
                .background(thumbColor, CircleShape)
        )
    }

}