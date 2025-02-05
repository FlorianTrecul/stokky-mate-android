package com.floriantrecul.stokkymate.core.common.di

import com.floriantrecul.stokkymate.core.common.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val commonModule = module {

    single {
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            default = Dispatchers.Default,
            main = Dispatchers.Main,
        )
    }

    val supervisorJob = SupervisorJob()
    factory { CoroutineScope(Dispatchers.IO + supervisorJob) }
}
