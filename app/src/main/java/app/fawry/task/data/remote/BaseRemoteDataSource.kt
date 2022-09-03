package app.fawry.task.data.remote

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import app.fawry.task.domain.utils.BaseResponse
import app.fawry.task.domain.utils.ErrorResponse
import app.fawry.task.domain.utils.FailureStatus
import app.fawry.task.domain.utils.Resource
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

open class BaseRemoteDataSource @Inject constructor() {
  var gson: Gson = Gson()

  suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    println(apiCall)
    try {
      val apiResponse = apiCall.invoke()
      return Resource.Success(apiResponse)
    } catch (throwable: Throwable) {
      when (throwable) {
        is HttpException -> {
          when {
            throwable.code() == 401 -> {
              val errorResponse = Gson().fromJson(
                throwable.response()?.errorBody()!!.charStream().readText(),
                ErrorResponse::class.java
              )
              return Resource.Failure(
                FailureStatus.INVALID_TOKEN,
                throwable.code(),
                errorResponse.detail
              )
            }
            throwable.code() == 404 -> {
              val errorResponse = Gson().fromJson(
                throwable.response()?.errorBody()!!.charStream().readText(),
                ErrorResponse::class.java
              )

              return Resource.Failure(
                FailureStatus.API_FAIL,
                throwable.code(),
                errorResponse.detail
              )
            }
            else -> {
              return if (throwable.response()?.errorBody()!!.charStream().readText().isEmpty()) {
                Resource.Failure(FailureStatus.API_FAIL, throwable.code())
              } else {
                try {
                  val errorResponse = Gson().fromJson(
                    throwable.response()?.errorBody()!!.charStream().readText(),
                    ErrorResponse::class.java
                  )
                  Resource.Failure(FailureStatus.API_FAIL, throwable.code(), errorResponse?.detail)
                } catch (ex: JsonSyntaxException) {
                  Resource.Failure(FailureStatus.API_FAIL, throwable.code())
                }
              }
            }
          }
        }

        is UnknownHostException -> {
          return Resource.Failure(FailureStatus.NO_INTERNET)
        }

        is ConnectException -> {
          return Resource.Failure(FailureStatus.NO_INTERNET)
        }

        else -> {
          return Resource.Failure(FailureStatus.OTHER)
        }
      }
    }
  }
}