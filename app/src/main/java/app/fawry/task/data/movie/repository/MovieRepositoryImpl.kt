package app.fawry.task.data.movie.repository

import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.data.movie.data_source.remote.MovieRemoteDataSource
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryRepository
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.movie.repository.MovieRepository
import app.fawry.task.domain.utils.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteDataSource: MovieRemoteDataSource) :
  MovieRepository {
  override suspend fun getMovies(): Resource<MovieResponse> = remoteDataSource.getMovies()

}