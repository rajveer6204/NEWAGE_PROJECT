package com.example.nearnestapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Home : Screen("home")
    object Browse : Screen("browse")
    object ItemDetails : Screen("item_details")
}
