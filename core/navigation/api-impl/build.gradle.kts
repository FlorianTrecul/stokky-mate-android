plugins {
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.core.navigation.apiimpl"
}

dependencies {
    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)

    // Koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)

    // Module
    implementation(projects.core.common)
    implementation(projects.core.navigation.api)
}
