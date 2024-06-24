package com.example.flightsearch.adapters

import android.annotation.SuppressLint
import android.util.LayoutDirection
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.example.data.models.Offer
import com.example.flightsearch.R
import com.example.flightsearch.databinding.OfferLayoutBinding
import com.example.flightsearch.utils.divideIntoThreeDigits
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
internal fun offerAdapterDelegate() =
    adapterDelegateViewBinding<Offer, Offer, OfferLayoutBinding>({ layoutInflater, parent ->
        OfferLayoutBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }) {
        bind {
            with(binding) {
                artistName.text = item.title
                location.text = item.town
                price.text = "от " + item.price.toString().divideIntoThreeDigits() + " ₽"
                val imageId = when (item.id) {
                    1 -> R.drawable.offer1
                    2 -> R.drawable.offer2
                    3 -> R.drawable.offer3
                    else -> R.drawable.rounded_button
                }
                offerImage.load(imageId)

                val itemCount = (bindingAdapter as ListDelegationAdapter<*>).itemCount
                if (bindingAdapterPosition == itemCount - 1) {
                    val rootParams = root.layoutParams
                    rootParams.width = ConstraintLayout.LayoutParams.WRAP_CONTENT
                    root.layoutParams = rootParams
                } else {
                    val displayMetrics = itemView.context.resources.displayMetrics
                    val screenWidth = displayMetrics.widthPixels
                    // 160dp = marginStart + marginEnd + OfferImageWight
                    // two elements are visible on the screen at the same time
                    // on the sides of the screen,
                    // unnecessary indentation has been removed for the latter
                    val marginInPixels = (160 * displayMetrics.density).toInt()
                    val itemWidth = screenWidth - marginInPixels
                    val rootParams = root.layoutParams
                    rootParams.width = itemWidth
                    root.layoutParams = rootParams
                }
            }

        }
    }