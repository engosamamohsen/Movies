package app.fawry.task.core.di.module

import app.fawry.task.domain.user.repository.HomeRepository
import app.fawry.task.domain.user.use_case.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

  @Provides
  @Singleton
  fun provideHomeUseCase(
    usersRepository: HomeRepository
  ): HomeUseCase = HomeUseCase(usersRepository)
}