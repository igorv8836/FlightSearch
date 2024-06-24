package com.example.flightsearch.fragments.searchfragment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.common.R
import com.example.common.Text2

@Composable
fun RouteElement(id: Int, iconId: Int, text: String, iconBackground: Int, onClick: (id: Int) -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(
                    color = colorResource(id = iconBackground),
                    shape = RoundedCornerShape(8.dp)
                ).clickable(onClick = { onClick(id) }),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = colorResource(id = R.color.white),
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            style = Text2,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier.wrapContentSize()
        )
    }
}