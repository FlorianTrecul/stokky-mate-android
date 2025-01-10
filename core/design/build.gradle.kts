plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.design"
}

dependencies {
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Compose Core
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)

    // Fonts
    implementation(libs.androidx.compose.ui.text.google.fonts)

    // Log
    implementation(libs.timber)
}