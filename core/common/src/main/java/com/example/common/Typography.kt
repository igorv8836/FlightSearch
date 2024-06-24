package com.example.common

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val SfProDisplayRegular = FontFamily(Font(R.font.sf_pro_display_regular, FontWeight.Normal))
val SfProDisplayMedium = FontFamily(Font(R.font.sf_pro_display_medium, FontWeight.Normal))
val SfProDisplaySemibold = FontFamily(Font(R.font.sf_pro_display_semibold, FontWeight.Normal))

val Title1 = TextStyle(
    fontFamily = SfProDisplaySemibold,
    fontSize = Dimens.size5
)

val Title2 = TextStyle(
    fontFamily = SfProDisplaySemibold,
    fontSize = Dimens.size4
)

val Title3 = TextStyle(
    fontFamily = SfProDisplayMedium,
    fontSize = Dimens.size3
)

val Title4 = TextStyle(
    fontFamily = SfProDisplayRegular,
    fontSize = Dimens.size2
)

val Text1 = TextStyle(
    fontFamily = SfProDisplayRegular,
    fontSize = Dimens.size3
)

val Text2 = TextStyle(
    fontFamily = SfProDisplayRegular,
    fontSize = Dimens.size2
)

val ButtonText1 = TextStyle(
    fontFamily = SfProDisplayRegular,
    fontSize = Dimens.size3
)

val TabText = TextStyle(
    fontFamily = SfProDisplayMedium,
    fontSize = Dimens.size1
)