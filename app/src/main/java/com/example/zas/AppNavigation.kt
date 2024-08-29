package com.example.zas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var currentRoute by remember { mutableStateOf(Screen.Home.route) }

    MainScreenView(currentRoute,navController) { paddingValues ->
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(paddingValues) }
        composable(Screen.CreditCard.route) { CreditCardScreen(paddingValues) }
        composable(Screen.Send.route) { SendScreen(navController, onRouteChange = { currentRoute = it }) }
        composable(Screen.User.route) { UserScreen(navController, onRouteChange = { currentRoute = it }) }
    }
    }
}