package com.floriantrecul.core.navigation.apiimpl.di

import com.floriantrecul.core.navigation.api.NavControllerAccessor
import com.floriantrecul.core.navigation.apiimpl.manager.NavigationManager
import com.floriantrecul.core.navigation.apiimpl.manager.NavigationManagerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navigationModule = module {

    singleOf(::NavigationManagerImpl) {
        bind<NavigationManager>()
        bind<NavControllerAccessor>()
    }
}
