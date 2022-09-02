package app.fawry.task.core.di.module

import app.fawry.task.data.home.data_source.remote.UsersServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideUsersServices(retrofit: Retrofit): UsersServices =
    retrofit.create(UsersServices::class.java)


}