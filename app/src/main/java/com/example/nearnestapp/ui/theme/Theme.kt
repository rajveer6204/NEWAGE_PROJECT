package com.example.nearnestapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PurplePrimary,
    secondary = PurpleLight,
    tertiary = PurpleDark,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
)

private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    secondary = PurpleLight,
    tertiary = PurpleDark,
    background = BackgroundWhite,
    surface = SurfaceGray,
    onPrimary = Color.White,
    onBackground = TextDark,
    onSurface = TextDark,
)

@Composable
fun NearNestAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
