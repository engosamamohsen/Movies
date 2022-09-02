package app.fawry.task.data.home.data_source.remote

import app.fawry.task.domain.user.models.User
import retrofit2.http.GET

interface UsersServices {
  @GET("users")
  suspend fun users(): List<User>

}