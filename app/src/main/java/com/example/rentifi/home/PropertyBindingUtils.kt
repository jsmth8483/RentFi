package com.example.rentifi.home

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.rentifi.database.models.Property

@BindingAdapter("propertyTitleText")
fun TextView.setPropertyTitleText(item: Property) {
    text = item.title
}

@BindingAdapter("propertyAddressText")
fun TextView.setPropertyAddressText(item: Property) {
    text = item.address
}