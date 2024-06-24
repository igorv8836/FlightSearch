package com.example.flightsearch.utils

import android.text.InputFilter
import android.text.Spanned

internal class CyrillicInputFilter : InputFilter {
    private val cyrillicPattern = Regex("[а-яА-ЯёЁ ]*")

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        val filtered = StringBuilder()
        for (i in start until end) {
            val char = source[i]
            if (cyrillicPattern.matches(char.toString())) {
                filtered.append(char)
            }
        }
        return if (filtered.isNotEmpty()) filtered.toString() else ""
    }
}
