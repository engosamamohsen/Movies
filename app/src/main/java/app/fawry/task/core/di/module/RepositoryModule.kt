package app.fawry.task.core.di.module

import app.fawry.task.data.home.data_source.remote.HomeRemoteDataSource
import app.fawry.task.data.home.repository.HomeRepositoryImpl
import app.fawry.task.domain.user.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun provideHomeRepository(
    remoteDataSource: HomeRemoteDataSource
  ): HomeRepository = HomeRepositoryImpl(remoteDataSource)

}