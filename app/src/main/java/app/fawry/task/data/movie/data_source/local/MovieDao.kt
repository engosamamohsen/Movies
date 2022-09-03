package app.fawry.task.data.movie.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.fawry.task.domain.movie.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
  @Query("Select * from movie")
  fun getMovies(): Flow<List<Movie>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(order: List<Movie>)
}