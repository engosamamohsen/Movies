package app.fawry.task.data.movie.data_source.remote

import app.fawry.task.data.category.data_source.remote.MovieServices
import app.fawry.task.data.remote.BaseRemoteDataSource
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.utils.Constants
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val apiService: MovieServices) :
  BaseRemoteDataSource() {
  suspend fun getMovies() = safeApiCall {
    apiService.getMovies()
  }

}