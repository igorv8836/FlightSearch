package com.example.flightsearch.fragments.searchfragment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import com.example.common.ButtonText1
import com.example.common.R

@Composable
internal fun SearchTextField(
    textFieldState: MutableState<String>,
    leadingIconId: Int,
    hintText: String,
    isEnabled: Boolean,
    leadingIconTint: Int,
    onDone: (KeyboardActionScope.() -> Unit)? = {}
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
                painter = painterResource(id = leadingIconId),
                contentDescription = null,
                tint = colorResource(
                    id = leadingIconTint
                )
            )
        },
        trailingIcon = {
            if (isEnabled)
                IconButton(onClick = { textFieldState.value = "" }) {
                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = null,
                        tint = colorResource(id = R.color.grey_6)
                    )
                }
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            if (textFieldState.value.isNotEmpty())
                onDone?.let { it() }
        }),
        readOnly = !isEnabled,
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