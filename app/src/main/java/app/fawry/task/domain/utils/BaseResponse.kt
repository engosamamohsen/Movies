package app.fawry.task.domain.utils

data class BaseResponse<T>(
  val data: T,
  val message: String,
  val code: Int,
)