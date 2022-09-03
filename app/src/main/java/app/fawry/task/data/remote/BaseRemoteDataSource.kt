package app.fawry.task.data.remote

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import app.fawry.task.domain.utils.BaseResponse
import app.fawry.task.domain.utils.ErrorResponse
import app.fawry.task.domain.utils.FailureStatus
import app.fawry.task.domain.utils.Resource
import org.json.JSONObject
import retrofit2.HttpException
import java.lang.Exception
import java.net.ConnectException
import java.net.UnknownHostException
import java.util.HashMap
import javax.inject.Inject

open class BaseRemoteDataSource @Inject constructor() {
  var gson: Gson = Gson()

  suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    println(apiCall)
    try {
      val apiResponse = apiCall.invoke()
      println(apiResponse)
      return Resource.Success(apiResponse)
//      when ((apiResponse as BaseResponse<*>).code) {
//        403 -> {
//          return Resource.Failure(FailureStatus.TOKEN_EXPIRED)
//        }
//        200 -> {
//          return Resource.Success(apiResponse)
//        }
//        401 -> {
//          return Resource.Failure(
//            FailureStatus.EMPTY,
//            (apiResponse as BaseResponse<*>).code,
//            (apiResponse as BaseResponse<*>).message
//          )
//        }
//        405 -> {
//          return Resource.Failure(
//            FailureStatus.NOT_ACTIVE,
//            (apiResponse as BaseResponse<*>).code,
//            (apiResponse as BaseResponse<*>).message
//          )
//        }
//        else -> {
//          return Resource.Failure(FailureStatus.API_FAIL)
//        }
//      }
    } catch (throwable: Throwable) {
      println("throwable:"+throwable)
      when (throwable) {
        is HttpException -> {
          when {
            throwable.code() == 422 -> {
              val jObjError = JSONObject(throwable.response()!!.errorBody()!!.string())
              val apiResponse = jObjError.toString()
              val response = Gson().fromJson(apiResponse, BaseResponse::class.java)

              return Resource.Failure(FailureStatus.API_FAIL, throwable.code(), response.message)
            }
            throwable.code() == 401 -> {
              val errorResponse = Gson().fromJson(
                throwable.response()?.errorBody()!!.charStream().readText(),
                ErrorResponse::class.java
              )
              return Resource.Failure(
                FailureStatus.TOKEN_EXPIRED,
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
            throwable.code() == 500 -> {
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