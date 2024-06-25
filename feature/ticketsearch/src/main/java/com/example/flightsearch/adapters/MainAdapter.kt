package com.example.flightsearch.adapters

import com.example.data.models.Offer
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

internal class MainAdapter : ListDelegationAdapter<List<Offer>>() {
    init {
        delegatesManager.addDelegate(offerAdapterDelegate())
    }
}