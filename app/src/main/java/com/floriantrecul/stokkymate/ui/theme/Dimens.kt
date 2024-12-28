package com.floriantrecul.stokkymate.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {

    // Padding / Margin
    object Padding {
        val none = 0.dp
        val extraSmall = 4.dp
        val small = 8.dp
        val medium = 16.dp
        val large = 24.dp
        val extraLarge = 32.dp
        val xxLarge = 48.dp
    }

    // Icon Sizes
    private object Icon {
        val extraSmall = 12.dp
        val small = 16.dp
        val medium = 24.dp
        val large = 32.dp
        val extraLarge = 48.dp
    }

    // Text Sizes
    private object Text {
        val extraSmall = 10.sp
        val small = 12.sp
        val medium = 14.sp
        val large = 18.sp
        val extraLarge = 24.sp
        val titleSmall = 28.sp
        val titleLarge = 32.sp
        val headline = 40.sp
    }

    // Image Sizes
    private object Image {
        val extraSmall = 48.dp
        val small = 64.dp
        val medium = 96.dp
        val large = 144.dp
        val extraLarge = 192.dp
    }

    // Elevation
    private object Elevation {
        val none = 0.dp
        val small = 2.dp
        val medium = 4.dp
        val large = 8.dp
        val extraLarge = 16.dp
    }

    // Border Widths
    private object Border {
        val none = 0.dp
        val thin = 1.dp
        val medium = 2.dp
        val thick = 4.dp
        val extraThick = 8.dp
    }

    // Radius (for rounded corners)
    private object Radius {
        val none = 0.dp
        val small = 4.dp
        val medium = 8.dp
        val large = 16.dp
        val extraLarge = 24.dp
        val full = 50.dp // For fully rounded elements like circular buttons
    }

    // Spacer Heights (Vertical spacing)
    private object Spacer {
        val extraSmall = 4.dp
        val small = 8.dp
        val medium = 16.dp
        val large = 24.dp
        val extraLarge = 32.dp
        val xxLarge = 48.dp
    }

    // Component-specific dimensions
    private object Component {
        val buttonHeight = 48.dp
        val appBarHeight = 56.dp
        val bottomNavBarHeight = 64.dp
        val cardCornerRadius = 16.dp
        val chipHeight = 32.dp
    }

    // Screen Width / Height Breakpoints (responsive design)
    private object Screen {
        val smallWidth = 360.dp
        val mediumWidth = 480.dp
        val largeWidth = 720.dp
        val smallHeight = 640.dp
        val mediumHeight = 800.dp
        val largeHeight = 1080.dp
    }
}