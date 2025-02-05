package com.floriantrecul.stokkymate.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            setupAndroidModule(isApplication = false)
            setupBaseDependencies()
        }
    }
}
