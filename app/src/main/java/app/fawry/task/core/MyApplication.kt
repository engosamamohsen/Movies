package app.fawry.task.core

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

  /**MultiDex: for Android 5.0 and higher natively supports loading multiple DEX files from APK files**/
  override
  fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

  override
  fun onCreate() {
    super.onCreate()
  }
}