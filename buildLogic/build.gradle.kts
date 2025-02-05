import org.gradle.initialization.DependenciesAccessors
import org.gradle.kotlin.dsl.support.serviceOf

plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)

    gradle.serviceOf<DependenciesAccessors>().classes.asFiles.forEach {
        compileOnly(files(it.absolutePath))
    }
}

group = "com.floriantrecul.stokkymate.buildLogic"

gradlePlugin {
    plugins {
        register("moduleAndroidApplication") {
            id = "com.floriantrecul.stokkymate.module.android.application"
            implementationClass =
                "com.floriantrecul.stokkymate.buildlogic.AndroidApplicationModulePlugin"
        }
        register("moduleAndroidLibrary") {
            id = "com.floriantrecul.stokkymate.module.android.library"
            implementationClass =
                "com.floriantrecul.stokkymate.buildlogic.AndroidLibraryModulePlugin"
        }
        register("moduleAndroidPresentation") {
            id = "com.floriantrecul.stokkymate.module.android.presentation"
            implementationClass =
                "com.floriantrecul.stokkymate.buildlogic.AndroidPresentationModulePlugin"
        }
    }
}