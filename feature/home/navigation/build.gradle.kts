plugins {
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.feature.navigation"
}

dependencies {
    // Compose
    implementation(libs.androidx.activity.compose)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Modules
    implementation(projects.core.navigation.api)
}
