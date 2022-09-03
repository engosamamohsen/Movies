package app.fawry.task.core.di.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.fawry.task.data.category.data_source.local.CategoryDao
import app.fawry.task.data.movie.data_source.local.MovieDao
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.utils.Converter

@Database(
  entities = [Category::class, Movie::class],
  version = 1
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
  abstract val getCategories: CategoryDao
  abstract val getMovies: MovieDao
}