buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradle)
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    id(libs.plugins.detekt.get().pluginId) version libs.versions.detekt
}

subprojects {
    afterEvaluate {
        val lintChecks = "lintChecks"
        val composeLintChecks = "compose.lint.checks"

        plugins.withId(libs.plugins.android.library.get().pluginId) {
            dependencies {
                val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
                add(lintChecks, libs.findLibrary(composeLintChecks).get())
            }
        }
        plugins.withId(libs.plugins.android.application.get().pluginId) {
            dependencies {
                val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
                add(lintChecks, libs.findLibrary(composeLintChecks).get())
            }
        }
    }
}

val projectStructure = file(projectDir)
val configFile = files("$rootProject/../config/detekt/detekt.yml")
val kotlinFiles = "**/*.kt"
val resourcesFiles = "**/resources/**"
val buildFiles = "**/build/**"
val autoFix = project.hasProperty("detektAutoFix")

tasks.register<io.gitlab.arturbosch.detekt.Detekt>("detektAllModules") {

    description = "Runs Detekt analysis across all modules in the project"
    parallel = true
    ignoreFailures = false
    autoCorrect = autoFix
    buildUponDefaultConfig = true
    setSource(file(projectDir))
    config.setFrom(configFile)
    include("**/*.kt")
    exclude("**/resources/**", "**/build/**")

    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
    }
}
