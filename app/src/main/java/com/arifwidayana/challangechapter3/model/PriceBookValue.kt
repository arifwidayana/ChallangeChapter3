package com.arifwidayana.challangechapter3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceBookValue(
    val name: String?,
    val equity: Double?,
    val share: Double?,
    val priceShare: Double?
) : Parcelable
