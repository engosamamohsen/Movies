package app.fawry.task.data.movie.data_source.local

import app.fawry.task.data.remote.BaseRemoteDataSource
import app.fawry.task.domain.movie.entity.Movie
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val dao: MovieDao) :
  BaseRemoteDataSource() {
  suspend fun getMovies() = safeApiCall {
    dao.getMovies()
  }

  suspend fun insert(list: List<Movie>) = safeApiCall {
    dao.insert(list)
  }


}