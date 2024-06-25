package com.example.flightsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.flightsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = (binding.fragmentContainer.getFragment<NavHostFragment>())
            .findNavController()
        binding.bottomNavMenu.setupWithNavController(navController)

        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_flight -> {
                    navController.navigate(com.example.ticketsearch.R.id.ticket_search_nav_graph)
                    true
                }

                R.id.nav_hotels -> {
                    navController.navigate(com.example.hotels.R.id.hotels_nav_graph)
                    true
                }

                R.id.nav_maps -> {
                    navController.navigate(com.example.maps.R.id.maps_nav_graph)
                    true
                }

                R.id.nav_subscriptions -> {
                    navController.navigate(com.example.subscriptions.R.id.subscriptions_nav_graph)
                    true
                }

                R.id.nav_profile -> {
                    navController.navigate(com.example.profile.R.id.profile_nav_graph)
                    true
                }

                else -> false
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.parent?.id) {
                com.example.ticketsearch.R.id.ticket_search_nav_graph -> binding.bottomNavMenu.menu.findItem(
                    R.id.nav_flight
                ).isChecked = true

                com.example.hotels.R.id.hotels_nav_graph -> binding.bottomNavMenu.menu.findItem(R.id.nav_hotels).isChecked =
                    true

                com.example.maps.R.id.maps_nav_graph -> binding.bottomNavMenu.menu.findItem(R.id.nav_maps).isChecked =
                    true

                com.example.subscriptions.R.id.subscriptions_nav_graph -> binding.bottomNavMenu.menu.findItem(
                    R.id.nav_subscriptions
                ).isChecked = true

                com.example.profile.R.id.profile_nav_graph -> binding.bottomNavMenu.menu.findItem(R.id.nav_profile).isChecked =
                    true
            }
        }
    }
}