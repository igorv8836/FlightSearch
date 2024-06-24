package com.example.flightsearch.fragments.searchfragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.common.ButtonText1
import com.example.common.R

@Composable
internal fun MyTextField(
    textFieldState: MutableState<String>,
    iconId: Int,
    hintText: String,
    isEnabledClearButton: Boolean,
    leadingIconTint: Int
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
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = colorResource(
                    id = leadingIconTint
                )
            )
        },
        trailingIcon = {
            if (isEnabledClearButton)
                IconButton(onClick = { textFieldState.value = "" }) {
                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = null,
                        tint = colorResource(id = R.color.grey_6)
                    )
                }
        },
        textStyle = ButtonText1.copy(color = colorResource(id = R.color.white)),
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors()
            .copy(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
    )
}