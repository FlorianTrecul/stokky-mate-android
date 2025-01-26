package com.floriantrecul.stokkymate.navigation

import com.floriantrecul.feature.home.navigation.HomeScreenRoute
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.floriantrecul.core.navigation.api.NavControllerAccessor
import com.floriantrecul.presentation.HomeScreen

@Composable
fun StokkyMateNavigator(
    navController: NavHostController,
    navigationManager: NavControllerAccessor
) {
    DisposableEffect(navController) {
        navigationManager.setController(navController)
        onDispose {
            navigationManager.clear()
        }
    }

    NavHost(
        navController = navController,
        startDestination = HomeScreenRoute,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } },
    ) {
        composable<HomeScreenRoute> {
            HomeScreen()
        }
    }
}
