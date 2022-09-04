package app.fawry.task.core

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.multidex.MultiDex
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application(), Configuration.Provider {

  @Inject
  lateinit var workerFactory: HiltWorkerFactory

  override fun getWorkManagerConfiguration() =
    Configuration.Builder()
      .setWorkerFactory(workerFactory)
      .build()


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