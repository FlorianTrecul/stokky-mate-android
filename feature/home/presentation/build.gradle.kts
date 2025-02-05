plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.floriantrecul.stokkymate.feature.home.presentation"
}

dependencies {
    // Modules
    implementation(projects.core.design)
}
