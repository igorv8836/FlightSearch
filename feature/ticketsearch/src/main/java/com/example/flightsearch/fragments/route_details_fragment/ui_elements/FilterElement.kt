package com.example.flightsearch.fragments.route_details_fragment.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common.Title4

@Composable
internal fun FilterElement(
    leadingIconId: Int? = null,
    leadingIconTint: Int? = null,
    text: String,
    addingText: String? = null,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = colorResource(id = com.example.common.R.color.grey_3),
                shape = CircleShape.copy(
                    CornerSize(16.dp)
                )
            )
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = rememberRipple()
            )
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
    ) {
        if (leadingIconId != null && leadingIconTint != null) {
            Icon(
                painter = painterResource(id = leadingIconId),
                tint = colorResource(id = leadingIconTint),
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
        Text(
            text = text,
            style = Title4.copy(color = colorResource(id = com.example.common.R.color.white)),
        )
        if (addingText != null)
            Text(
                text = addingText,
                style = Title4.copy(color = colorResource(id = com.example.common.R.color.grey_6)),
            )
    }
}