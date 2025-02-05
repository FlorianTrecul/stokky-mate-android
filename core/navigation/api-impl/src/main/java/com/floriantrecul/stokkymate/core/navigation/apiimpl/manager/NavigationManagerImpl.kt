package com.floriantrecul.stokkymate.core.navigation.apiimpl.manager

import androidx.navigation.NavController
import com.floriantrecul.stokkymate.core.common.AppCoroutineDispatchers
import com.floriantrecul.stokkymate.core.navigation.api.NavControllerAccessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NavigationManagerImpl(
    coroutineDispatchers: AppCoroutineDispatchers,
) : NavigationManager, NavControllerAccessor {

    private var navControllerFlow = MutableStateFlow<NavController?>(null)
    private val scope by lazy { CoroutineScope(SupervisorJob() + coroutineDispatchers.main) }
    override fun setController(navController: NavController) {
        this.navControllerFlow.update { navController }
    }

    override fun navigate(command: NavigationCommand) {
        scope.launch {
            getNavController().handleComposeNavigationCommand(command = command)
        }
    }

    override fun clear() {
        this.navControllerFlow.update { null }
    }

    private suspend fun getNavController() = navControllerFlow.mapNotNull { it }.first()

    private fun NavController.handleComposeNavigationCommand(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.NavigateToRoute -> {
                navigate(command.route, command.options)
            }

            NavigationCommand.NavigateUp -> navigateUp()
            is NavigationCommand.PopUpToRoute -> {
                val hasPopped = popBackStack(
                    command.route,
                    command.inclusive,
                )
                if (!hasPopped) {
                    popBackStack(
                        command.fallBackRoute,
                        command.inclusive,
                    )
                }
            }
        }
    }
}
