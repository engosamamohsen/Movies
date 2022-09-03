package app.fawry.task.core.di.module

import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.data.category.repository.CategoryRepositoryImpl
import app.fawry.task.domain.category.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** provide module for repository to use remoteDataSource in Repository **/
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun provideHomeRepository(
    remoteDataSource: CategoryRemoteDataSource
  ): CategoryRepository = CategoryRepositoryImpl(remoteDataSource)

}