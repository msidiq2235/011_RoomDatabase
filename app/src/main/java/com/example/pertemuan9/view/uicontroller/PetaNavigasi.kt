package com.example.pertemuan9.uicontroller

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
import com.example.pertemuan9.view.EditSiswaScreen
import com.example.pertemuan9.view.EntrySiswaScreen
import com.example.pertemuan9.view.HomeScreen
import com.example.pertemuan9.view.route.DestinasiDetailSiswa
import com.example.pertemuan9.view.route.DestinasiEditSiswa
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
        // --- 1. Halaman Home ---
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToDetail = { siswaId ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$siswaId")
                }
            )
        }

        // --- 2. Halaman Entry (Tambah) ---
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() },
            )
        }

        // --- 3. Halaman Detail ---
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { siswaId ->
                    navController.navigate("${DestinasiEditSiswa.route}/$siswaId")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        // --- 4. Halaman Edit  ---
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}