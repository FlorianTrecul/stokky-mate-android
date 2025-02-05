import com.floriantrecul.stokkymate.buildlogic.ProjectConfig
import com.floriantrecul.stokkymate.buildlogic.implementation

plugins {
    alias(libs.plugins.module.android.application)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = ProjectConfig.APPLICATION_ID

    defaultConfig {
        applicationId = ProjectConfig.APPLICATION_ID
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Modules
    implementation(projects.core.common)
    implementation(projects.core.design)
    implementation(projects.core.logging)
    implementation(projects.core.navigation.api)
    implementation(projects.core.navigation.apiImpl)
    implementation(projects.feature.home.navigation)
    implementation(projects.feature.home.presentation)
}
