package app.fawry.task.domain.utils

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
  val data: T,
  @SerializedName("status_message")
  val message: String,
  @SerializedName("status_code")
  val code: Int,
)