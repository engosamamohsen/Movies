package app.fawry.task.domain.movie.use_case

import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryRepository
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.movie.repository.MovieRepository
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject


class MovieUseCase @Inject constructor(
  private val repository: MovieRepository
) {
  /**
   * invoke function will be call directly
   * */
  operator fun invoke(): Flow<Resource<MovieResponse>> = flow {

    emit(Resource.Loading) //show loader
    val result = repository.getMovies() //call api categories
    if (result is Resource.Success) {
      result.value.movies.map {
        it.posterPath = Constants.IMAGE_PATH + it.posterPath
      }
    }
    emit(result)//send result for collecting
  }.flowOn(Dispatchers.IO)

}