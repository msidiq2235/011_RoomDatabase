package com.example.pertemuan9.controller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan9.view.DetailSiswaScreen
import com.example.pertemuan9.view.EntrySiswaScreen
import com.example.pertemuan9.view.HomeScreen
import com.example.pertemuan9.view.route.DestinasiDetailSiswa
import com.example.pertemuan9.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.pertemuan9.view.route.DestinasiEntry
import com.example.pertemuan9.view.route.DestinasiHome

@Composable
fun SiswaApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToltemEntry = { navController.navigate(DestinasiEntry.route) },
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() },
            )
        }

        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = {navController.navigateUp()}
            )
        }
    }
}