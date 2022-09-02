package app.fawry.task.data.home.data_source.remote

import app.fawry.task.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(private val apiService: UsersServices) :
  BaseRemoteDataSource() {
  suspend fun users() = safeApiCall {
    apiService.users()
  }

}