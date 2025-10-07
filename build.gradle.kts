// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // hilt plugin for dependency injection
    // but noy applied globally apply(false)
    // keeps it available for modules that explicitly apply it

    // there is for hilt
    id("com.google.dagger.hilt.android") version "2.57.2" apply false

    //Kotlin sympol Processing (KSP) plugin
    // Applied immedittely at the root with version 2.2.20-2.0.3
    // required to run annotation processors
    id("com.google.devtools.ksp") version "2.2.20-2.0.3" apply false

}