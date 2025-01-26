package com.floriantrecul.stokkymate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.floriantrecul.core.design.theme.StokkyMateTheme
import com.floriantrecul.core.navigation.api.NavControllerAccessor
import com.floriantrecul.stokkymate.navigation.StokkyMateNavigator
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StokkyMateTheme {
                val navController = rememberNavController()
                val navigationManager: NavControllerAccessor = get()

                StokkyMateNavigator(
                    navController = navController,
                    navigationManager = navigationManager
                )
            }
        }
    }
}

