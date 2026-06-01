package com.sjdworkfile.loanmanager.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sjdworkfile.loanmanager.presentation.screens.DashboardScreen
import com.sjdworkfile.loanmanager.presentation.screens.LoansScreen
import com.sjdworkfile.loanmanager.presentation.screens.AssetsScreen
import com.sjdworkfile.loanmanager.presentation.screens.ReportsScreen
import com.sjdworkfile.loanmanager.presentation.screens.SettingsScreen

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object Loans : Screen("loans")
    object Assets : Screen("assets")
    object Reports : Screen("reports")
    object Settings : Screen("settings")
}

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(Screen.Loans.route) {
            LoansScreen(navController)
        }
        composable(Screen.Assets.route) {
            AssetsScreen(navController)
        }
        composable(Screen.Reports.route) {
            ReportsScreen(navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}
