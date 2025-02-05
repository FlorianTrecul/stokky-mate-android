plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.floriantrecul.stokkymate.design"
}

dependencies {
    // Fonts
    implementation(libs.androidx.compose.ui.text.google.fonts)

}