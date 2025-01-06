plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.logging"
}

dependencies {
    // Compose
    implementation(libs.androidx.activity.compose)

    // Log
    implementation(libs.timber)
}