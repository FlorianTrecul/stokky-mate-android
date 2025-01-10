package com.floriantrecul.core.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceContainer = LightSurfaceContainer,
    onSurfaceVariant = LightOnSurfaceContainer,
    outline = LightOutline,
    outlineVariant = LightOutlineVariant,
    inverseSurface = LightInverseSurface,
    inverseOnSurface = LightInverseOnSurface,
    inversePrimary = LightInversePrimary,
)

private val DarkColorScheme = darkColorScheme(
    primary = BlackPrimary,
    onPrimary = BlackOnPrimary,
    primaryContainer = BlackPrimaryContainer,
    onPrimaryContainer = BlackOnPrimaryContainer,
    secondary = BlackSecondary,
    onSecondary = BlackOnSecondary,
    secondaryContainer = BlackSecondaryContainer,
    onSecondaryContainer = BlackOnSecondaryContainer,
    tertiary = BlackTertiary,
    onTertiary = BlackOnTertiary,
    tertiaryContainer = BlackTertiaryContainer,
    onTertiaryContainer = BlackOnTertiaryContainer,
    error = BlackError,
    onError = BlackOnError,
    errorContainer = BlackErrorContainer,
    onErrorContainer = BlackOnErrorContainer,
    surface = BlackSurface,
    onSurface = BlackOnSurface,
    surfaceContainer = BlackSurfaceContainer,
    onSurfaceVariant = BlackOnSurfaceContainer,
    outline = BlackOutline,
    outlineVariant = BlackOutlineVariant,
    inverseSurface = BlackInverseSurface,
    inverseOnSurface = BlackInverseOnSurface,
    inversePrimary = BlackInversePrimary,
)

@Composable
fun StokkyMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
