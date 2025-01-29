package com.floriantrecul.stokkymate.core.navigation.apiimpl.di

import com.floriantrecul.stokkymate.core.navigation.api.NavControllerAccessor
import com.floriantrecul.stokkymate.core.navigation.apiimpl.manager.NavigationManager
import com.floriantrecul.stokkymate.core.navigation.apiimpl.manager.NavigationManagerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navigationModule = module {

    singleOf(::NavigationManagerImpl) {
        bind<NavigationManager>()
        bind<NavControllerAccessor>()
    }
}
