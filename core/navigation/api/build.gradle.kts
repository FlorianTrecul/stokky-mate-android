plugins {
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.core.navigation.api"
}

dependencies {
    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
}
