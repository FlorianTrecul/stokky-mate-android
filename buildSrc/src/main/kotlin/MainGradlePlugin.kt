import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class MainGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project = project)
        setProjectConfig(project = project)
    }

    private fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN_ANDROID)
        }
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = ProjectConfig.COMPILE_SDK

            defaultConfig {
                minSdk = ProjectConfig.MIN_SDK
                testInstrumentationRunner = ProjectConfig.TEST_INSTRUMENTATION_RUNNER
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            buildFeatures {
                buildConfig = true
                compose = true
            }
        }
    }

    private fun Project.android(): LibraryExtension =
        extensions.getByType(LibraryExtension::class.java)
}
