package com.example.asramaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asramaapp.ui.view.mahasiswa.DestinasiEntryMahasiswa
import com.example.asramaapp.ui.view.mahasiswa.DestinasiHomeMahasiswa
import com.example.asramaapp.ui.view.mahasiswa.EntryMhsScreen
import com.example.asramaapp.ui.view.mahasiswa.HomeScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHomeMahasiswa.route,
        modifier = Modifier,
    ) {
        // Home Screen
        composable(DestinasiHomeMahasiswa.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntryMahasiswa.route) },
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiHomeMahasiswa}/$nim")
                }
            )
        }

        // Entry Mahasiswa Screen
        composable(DestinasiEntryMahasiswa.route) {
            EntryMhsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHomeMahasiswa.route) {
                        popUpTo(DestinasiHomeMahasiswa.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }


}