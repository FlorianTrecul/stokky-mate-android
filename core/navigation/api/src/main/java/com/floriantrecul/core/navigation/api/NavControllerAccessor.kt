package com.floriantrecul.core.navigation.api

import androidx.navigation.NavController

interface NavControllerAccessor {

    fun setController(navController: NavController)
    fun clear()
}
