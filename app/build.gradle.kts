plugins {
  id(Config.Plugins.androidApplication)
  id(Config.Plugins.kotlinAndroid)
  id(Config.Plugins.kotlinKapt)
  id(Config.Plugins.navigationSafeArgs)
  id(Config.Plugins.hilt)
  id(Config.Plugins.extensions)
//  id(Config.Plugins.google_services)
}

android {
  compileSdk = Config.AppConfig.compileSdkVersion

  defaultConfig {
    applicationId = Config.AppConfig.appId
    minSdk = Config.AppConfig.minSdkVersion
    targetSdk = Config.AppConfig.compileSdkVersion
    versionCode = Config.AppConfig.versionCode
    versionName = Config.AppConfig.versionName

    vectorDrawables.useSupportLibrary = true
    multiDexEnabled = true
    testInstrumentationRunner = Config.AppConfig.testRunner

  }

  buildTypes {
    getByName("debug") {
      manifestPlaceholders["appName"] = "@string/app_name_debug"
      manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_debug"
      manifestPlaceholders["appRoundIcon"] = "@mipmap/ic_launcher_round_debug"
      buildConfigField("String", "API_BASE_URL", Config.Environments.debugBaseUrl)
      buildConfigField("String", "ROOM_DB", Config.Environments.roomDb)
      buildConfigField("String", "APIKEY", Config.Environments.APIKEY)
    }

    signingConfigs {
      create("releaseConfig") {
        storeFile = file(rootProject.file("/home/t-e-s/Downloads/GrandKey"))
        storePassword = "fawry2022"
        keyAlias = "fawry"
        keyPassword = "fawry2022"
      }
    }

    getByName("release") {
      signingConfig = signingConfigs.getByName("releaseConfig")

      isMinifyEnabled = true
      isShrinkResources = true

//      resValue("string", "google_api_key", gradleLocalProperties(rootDir).getProperty("GOOGLE_API_KEY"))
      manifestPlaceholders["appName"] = "@string/app_name"
      manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_debug"
      manifestPlaceholders["appRoundIcon"] = "@mipmap/ic_launcher_round_debug"

      buildConfigField("String", "API_BASE_URL", Config.Environments.releaseBaseUrl)
      buildConfigField("String", "ROOM_DB", Config.Environments.roomDb)
      buildConfigField("String", "APIKEY", Config.Environments.APIKEY)
    }
  }

  compileOptions {

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = "11"
  }

  dataBinding {
    isEnabled = true
  }

}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  //Room
  implementation(Libraries.roomVersion)
  kapt(Libraries.roomCompiler)
  implementation(Libraries.roomktx)
  implementation(Libraries.roomCommon)

  // Networking
  implementation(Libraries.retrofit)
  implementation(Libraries.retrofitConverter)
  implementation(Libraries.gson)
  implementation(Libraries.interceptor)
  implementation(Libraries.chuckLogging)

  // Utils
//  implementation(Libraries.playServices)
  implementation(Libraries.multidex)
  implementation(Libraries.gson)

  // Hilt
  implementation(Libraries.hilt)
  kapt(Libraries.hiltDaggerCompiler)
  // Support
  implementation(Libraries.appCompat)
  implementation(Libraries.coreKtx)
  implementation(Libraries.androidSupport)

  // Arch Components
  implementation(Libraries.viewModel)
  implementation(Libraries.lifeData)
  implementation(Libraries.lifecycle)
  implementation(Libraries.viewModelState)

  // Kotlin Coroutines
  implementation(Libraries.coroutinesCore)
  implementation(Libraries.coroutinesAndroid)


  //glide
  implementation (Libraries.glide)
  annotationProcessor (Libraries.glideCompiler)

  // UI
  implementation(Libraries.materialDesign)
  implementation(Libraries.navigationFragment)
  implementation(Libraries.navigationUI)
  implementation(Libraries.loadingAnimations)
  implementation(Libraries.alerter)

}
