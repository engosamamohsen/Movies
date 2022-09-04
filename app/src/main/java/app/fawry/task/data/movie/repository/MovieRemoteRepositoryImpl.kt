package app.fawry.task.data.movie.repository

import app.fawry.task.data.movie.data_source.remote.MovieRemoteDataSource
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.movie.repository.MovieRemoteRepository
import app.fawry.task.domain.utils.Resource
import javax.inject.Inject

class MovieRemoteRepositoryImpl @Inject constructor(private val remoteDataSource: MovieRemoteDataSource) :
  MovieRemoteRepository {
  override suspend fun getMovies(): Resource<MovieResponse> = remoteDataSource.getMovies()

}