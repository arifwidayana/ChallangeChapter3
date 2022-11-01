package com.arifwidayana.challangechapter3.utils

import java.text.DecimalFormat
import java.util.*

fun currency(
    onChangedCurrency: String? = null
): String {
    val formatCurrency = DecimalFormat.getCurrencyInstance(Locale("id","ID"))
    return try {
        formatCurrency.format(
            onChangedCurrency?.replace(String.format(
                "[%s,.]",
                Objects.requireNonNull(formatCurrency.currency?.displayName)
            ).toRegex(), "")?.toBigDecimal()
        )
    } catch (e: Exception) {
        e.toString()
    }
}