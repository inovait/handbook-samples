package com.example.android.architecture.blueprints.todoapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Inova brand palette (extracted from the Inova slide-template brand guidelines).
val InovaDarkGray = Color(0xFF161616) // Primary dark background
val InovaDirtyWhite = Color(0xFFF0EDE9) // Primary light background
val InovaLightGray = Color(0xFF7C7C7C) // Secondary info, disabled states
val InovaMediumGray = Color(0xFF3F3F3F) // Secondary info
val InovaAntiqueGold = Color(0xFF85754D) // Accent / highlight

@Composable
fun TodoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = InovaDarkGray,
            onPrimary = InovaDirtyWhite,
            secondary = InovaAntiqueGold,
            onSecondary = InovaDirtyWhite,
            tertiary = InovaLightGray,
            onTertiary = InovaDirtyWhite,
            background = InovaDirtyWhite,
            onBackground = InovaDarkGray,
            surface = InovaDirtyWhite,
            onSurface = InovaDarkGray,
            surfaceVariant = InovaDirtyWhite,
            onSurfaceVariant = InovaMediumGray,
        )
    ) {
        content()
    }
}
