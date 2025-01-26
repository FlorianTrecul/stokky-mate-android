plugins {
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.kotlin.compose)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.floriantrecul.stokkymate.core.common"
}

dependencies {
    // Coroutine
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)

    // Koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)
}
