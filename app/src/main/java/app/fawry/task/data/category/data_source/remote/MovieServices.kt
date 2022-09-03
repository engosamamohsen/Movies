package app.fawry.task.data.category.data_source.remote

import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.movie.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {
  @GET("genre/movie/list")
  suspend fun getCategories(): CategoryResponse

  @GET("discover/movie")
  suspend fun getMovies(): MovieResponse


}