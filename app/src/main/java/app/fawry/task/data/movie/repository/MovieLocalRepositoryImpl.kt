package app.fawry.task.data.movie.repository

import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.data.movie.data_source.local.MovieLocalDataSource
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryLocalRepository
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.movie.repository.MovieLocalRepository
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieLocalRepositoryImpl @Inject constructor(private val localDataSource: MovieLocalDataSource) :
  MovieLocalRepository {
  override suspend fun getMovies(): Flow<List<Movie>> = localDataSource.getMovies()
  override suspend fun count(): Flow<Int> = localDataSource.count()

  override suspend fun insert(list: List<Movie>) {
    localDataSource.insert(list)
  }

}