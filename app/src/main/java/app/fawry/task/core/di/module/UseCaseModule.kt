package app.fawry.task.core.di.module

import app.fawry.task.domain.category.repository.CategoryRepository
import app.fawry.task.domain.category.use_case.CategoryUseCase
import app.fawry.task.domain.movie.repository.MovieRepository
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
    repository: CategoryRepository
  ): CategoryUseCase = CategoryUseCase(repository)

  @Provides
  @Singleton
  fun provideMovieUseCase(
    repository: MovieRepository
  ): MovieUseCase = MovieUseCase(repository)
}