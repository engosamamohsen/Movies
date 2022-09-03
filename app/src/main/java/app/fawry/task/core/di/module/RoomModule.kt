package app.fawry.task.core.di.module

import android.content.Context
import androidx.room.Room
import app.fawry.task.core.di.room.AppDatabase
import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.data.movie.data_source.local.MovieLocalDataSource
import com.structure.base_mvvm.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

  @Provides
  @Singleton
  fun provideMyDB(@ApplicationContext context: Context): AppDatabase {


    return Room.databaseBuilder(
      context,
      AppDatabase::class.java,
      BuildConfig.ROOM_DB
    )
      .allowMainThreadQueries()
      .fallbackToDestructiveMigration()
//      .addMigrations(MIGRATION_1_2)
      .build()
  }

  @Provides
  @Singleton
  fun provideMovieLocalRepository(db: AppDatabase): MovieLocalDataSource {
    return MovieLocalDataSource(db.getMovies)
  }

  @Provides
  @Singleton
  fun provideCategoryLocalRepository(db: AppDatabase): CategoryLocalDataSource {
    return CategoryLocalDataSource(db.getCategories)
  }

}



