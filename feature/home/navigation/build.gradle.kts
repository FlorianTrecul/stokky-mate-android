plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.floriantrecul.stokkymate.feature.navigation"
}

dependencies {
    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Modules
    implementation(projects.core.navigation.api)
}
