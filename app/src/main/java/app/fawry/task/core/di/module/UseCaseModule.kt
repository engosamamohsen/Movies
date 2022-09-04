package app.fawry.task.core.di.module

import app.fawry.task.domain.category.repository.CategoryLocalRepository
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.category.use_case.CategoryUseCase
import app.fawry.task.domain.movie.repository.MovieLocalRepository
import app.fawry.task.domain.movie.repository.MovieRemoteRepository
import app.fawry.task.domain.movie.use_case.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** provide module for repository in UseCase **/
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun provideHomeUseCase(
    repositoryRemote: CategoryRemoteRepository,
    repositoryLocal: CategoryLocalRepository,
  ): CategoryUseCase = CategoryUseCase(repositoryRemote,repositoryLocal)

  @Provides
  @Singleton
  fun provideMovieUseCase(
    repository: MovieRemoteRepository,
  ): MovieUseCase = MovieUseCase(repository)

}