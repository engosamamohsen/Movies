package app.fawry.task.domain.movie.repository
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieLocalRepository {
  suspend fun getMovies(): Flow<List<Movie>>
  suspend fun count(): Flow<Int>
  suspend fun insert(list: List<Movie>)
}