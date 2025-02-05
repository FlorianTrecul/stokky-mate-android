import com.floriantrecul.stokkymate.buildlogic.implementation

plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.floriantrecul.stokkymate.core.navigation.apiimpl"
}

dependencies{
    implementation(libs.androidx.navigation.compose)

    implementation(projects.core.common)
    implementation(projects.core.navigation.api)
}
