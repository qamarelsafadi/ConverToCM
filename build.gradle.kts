// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    // todo 3: add kotlin-multiplatform plugin here
    alias(libs.plugins.kotlin.multiplatform) apply false
    // todo 5
    alias(libs.plugins.compose.multiplatform) apply false
    // todo 8 :
    alias(libs.plugins.compose.compiler) apply false
    // todo 13 :
    alias(libs.plugins.android.library) apply false

    // todo 16 :
    alias(libs.plugins.kotlin.native.cocopods) apply false

}