package app.fawry.task.core.di.module

import androidx.work.*
import app.fawry.task.data.background.ServiceApiManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/** provide Module AppPreferences for Application Context **/
@Module
@InstallIn(SingletonComponent::class)
object WorkManagerModule {
  // val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
  @Provides
  @Singleton
  fun providePeriodicWorkRequestUseCase() = PeriodicWorkRequest.Builder(
    ServiceApiManager::class.java,
    4 * 60, // 4 hour * 60 min
    TimeUnit.MINUTES
  ).setConstraints(
    Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
  ).build()
}