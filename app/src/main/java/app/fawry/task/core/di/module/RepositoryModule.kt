package app.fawry.task.core.di.module

import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.data.category.repository.CategoryLocalRepositoryImpl
import app.fawry.task.data.category.repository.CategoryRemoteRepositoryImpl
import app.fawry.task.data.movie.data_source.local.MovieLocalDataSource
import app.fawry.task.data.movie.data_source.remote.MovieRemoteDataSource
import app.fawry.task.data.movie.repository.MovieLocalRepositoryImpl
import app.fawry.task.data.movie.repository.MovieRemoteRepositoryImpl
import app.fawry.task.domain.category.repository.CategoryLocalRepository
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.movie.repository.MovieLocalRepository
import app.fawry.task.domain.movie.repository.MovieRemoteRepository
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
  ): CategoryRemoteRepository = CategoryRemoteRepositoryImpl(remoteDataSource)

  @Provides
  @Singleton
  fun provideMovieRepository(
    remoteDataSource: MovieRemoteDataSource
  ): MovieRemoteRepository = MovieRemoteRepositoryImpl(remoteDataSource)


  @Provides
  @Singleton
  fun provideCategoryLocalRepository(
    categoryLocalDataSource: CategoryLocalDataSource
  ): CategoryLocalRepository = CategoryLocalRepositoryImpl(categoryLocalDataSource)


  @Provides
  @Singleton
  fun provideMovieLocalRepository(
    movieLocalDataSource: MovieLocalDataSource
  ): MovieLocalRepository = MovieLocalRepositoryImpl(movieLocalDataSource)
}