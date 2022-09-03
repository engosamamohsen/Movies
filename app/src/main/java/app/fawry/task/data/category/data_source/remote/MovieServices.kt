package app.fawry.task.data.category.data_source.remote

import app.fawry.task.domain.category.entity.CategoryResponse
import retrofit2.http.GET

interface MovieServices {
  @GET("genre/movie/list")
  suspend fun getCategories(): CategoryResponse

}