package com.floriantrecul.stokkymate.core.navigation.apiimpl.manager

import androidx.navigation.NavOptions
import com.floriantrecul.stokkymate.core.navigation.api.NavigationRoute

sealed interface NavigationCommand {

    data object NavigateUp : NavigationCommand

    data class NavigateToRoute(val route: NavigationRoute, val options: NavOptions? = null) :
        NavigationCommand

    data class PopUpToRoute(
        val route: NavigationRoute,
        val inclusive: Boolean,
        val fallBackRoute: NavigationRoute,
    ) : NavigationCommand
}
