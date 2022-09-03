package app.fawry.task.data.category.data_source.remote

import app.fawry.task.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(private val apiService: MovieServices) :
  BaseRemoteDataSource() {
  suspend fun getCategories() = safeApiCall {
    apiService.getCategories()
  }

}