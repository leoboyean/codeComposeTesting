package com.genius.myappjpackcompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.genius.myappjpackcompose.DetailScreen
import com.genius.myappjpackcompose.HomeScreen
import com.genius.myappjpackcompose.LoginScreen
import com.genius.myappjpackcompose.SettingsScreen
import com.genius.myappjpackcompose.core.navigation.type.settingsInfoType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen {
                navController.navigate(Home)
            }
        }

        composable<Home> {
            HomeScreen { name ->
                navController.navigate(Detail(name = name))
            }
        }

        composable<Detail> {
            val detail = it.toRoute<Detail>()
            DetailScreen(
                name = detail.name,
                navigateBack = {
//                navController.popBackStack()
                navController.navigate(Login) {
                    popUpTo<Login> {
                        // true borrar todo hasta elr login
                        inclusive = true
                    }
                    //navigateUp() //to deeplinks
                }

            },
                navigateToSettings = {navController.navigate(Settings(it))}
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to settingsInfoType)) { backStackEntry ->
            val settings: Settings = backStackEntry.toRoute()
            SettingsScreen(settings.info)
        }
    }
}