package app.fawry.task.domain.movie.repository
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.utils.Resource

interface MovieRepository {
  suspend fun getMovies(): Resource<MovieResponse>
}