package com.example.watchlist.presentation.onboarding

import com.example.watchlist.R

class OnboardingItems(
    val image: Int,
    val title: String,
    val desc: String
) {
    companion object{
        fun getData() : List<OnboardingItems>{
            return listOf(
                OnboardingItems(R.drawable.snyder_cut,"Snyder Cut","Onboarding1"),
                OnboardingItems(R.drawable.super_deluxe,"Super Deluxe","Onboarding2"),
                OnboardingItems(R.drawable.snyder_cut,"Snyder Cut","Onboarding3"),
            )
        }
    }

}