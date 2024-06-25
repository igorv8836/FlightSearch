package com.example.flightsearch.fragments.route_details_fragment.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common.ButtonText1
import com.example.common.R

@Composable
internal fun RouteDetailsTextField(
    textFieldState: MutableState<String>,
    trailingIconId: Int,
    hintText: String,
    isEnabled: Boolean,
    trailingIconTint: Int,
    onClick: () -> Unit
) {
    TextField(
        value = textFieldState.value,
        onValueChange = { textFieldState.value = it },
        placeholder = {
            Text(
                text = hintText,
                color = colorResource(id = R.color.grey_6),
                style = ButtonText1
            )
        },
        trailingIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = painterResource(id = trailingIconId),
                    contentDescription = null,
                    tint = colorResource(id = trailingIconTint)
                )
            }
        },
        readOnly = !isEnabled,
        textStyle = ButtonText1.copy(color = colorResource(id = R.color.white)),
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth().height(54.dp),
        colors = TextFieldDefaults.colors()
            .copy(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
    )
}