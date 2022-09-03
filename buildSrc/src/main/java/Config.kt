object Config {
  object AppConfig {
    const val appId = "app.fawry.task"
    const val compileSdkVersion = 31
    const val minSdkVersion = 23
    const val versionCode = 1
    const val versionName = "1"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  object Dependencies {
    const val jitPackURL = "https://jitpack.io"
    const val gradleVersion = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgs =
      "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidNavigation}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val google_services = "com.google.gms:google-services:${Versions.google_services}"
    const val proto_buf = "com.google.protobuf:protobuf-gradle-plugin:${Versions.classPath_protobuf}"
  }

  object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val navigationSafeArgs = "androidx.navigation.safeargs"
    const val hilt = "dagger.hilt.android.plugin"
    const val ktLint = "org.jlleitschuh.gradle.ktlint"
    const val google_services = "com.google.gms.google-services"
    const val proto_buf = "com.google.protobuf"
  }

  object Environments {
    const val roomDb = "\"example_db\""
    const val debugBaseUrl = "\"https://api.themoviedb.org/3/\""
    const val releaseBaseUrl = "\"https://api.themoviedb.org/3/\""
    const val APIKEY = "\"c50f5aa4e7c95a2a553d29b81aad6dd0\""
  }
}