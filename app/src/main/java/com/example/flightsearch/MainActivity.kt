package com.example.flightsearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.flightsearch.databinding.ActivityMainBinding
import com.example.network.api.OffersApi
import com.example.network.api.TicketsApi
import com.example.network.api.TicketsOffersApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val test: TicketsOffersApi by inject()

        CoroutineScope(Dispatchers.IO).launch {
            val res = test.getTicketsOffers()
            Log.i("MainActivity", res.toString())
        }
    }
}