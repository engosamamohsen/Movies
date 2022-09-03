package app.fawry.task.core.di.module

import app.fawry.task.data.category.data_source.remote.MovieServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/** provide Module NetworkServicesModule for inject retrofit module in Movie-Services  **/
@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

  @Provides
  @Singleton
  fun provideMovieServices(retrofit: Retrofit): MovieServices =
    retrofit.create(MovieServices::class.java)

}