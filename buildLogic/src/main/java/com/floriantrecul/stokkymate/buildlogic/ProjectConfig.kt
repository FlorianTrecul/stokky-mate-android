package com.floriantrecul.stokkymate.buildlogic

object ProjectConfig {
    const val APPLICATION_ID = "com.floriantrecul.stokkymate"
    const val MIN_SDK = 28
    const val TARGET_SDK = 34
    const val COMPILE_SDK = 35

    private const val VERSION_MAJOR = 1
    private const val VERSION_MINOR = 0
    private const val VERSION_PATCH = 0

    const val VERSION_CODE = 1
    const val VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}
