package com.example.nearnestapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nearnestapp.ui.screens.BrowseScreen
import com.example.nearnestapp.ui.screens.HomeScreen
import com.example.nearnestapp.ui.screens.ItemDetailsScreen
import com.example.nearnestapp.ui.screens.LoginScreen
import com.example.nearnestapp.ui.screens.OnboardingScreen
import com.example.nearnestapp.ui.screens.SplashScreen

@Composable
fun NearNestNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToOnboarding = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onLoginClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToBrowse = {
                    navController.navigate(Screen.Browse.route)
                },
                onNavigateToItemDetails = {
                    navController.navigate(Screen.ItemDetails.route)
                }
            )
        }
        composable(Screen.Browse.route) {
            BrowseScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onItemClick = {
                    navController.navigate(Screen.ItemDetails.route)
                }
            )
        }
        composable(Screen.ItemDetails.route) {
            ItemDetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
