package app.fawry.task.domain.utils

import androidx.annotation.Keep
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

@Keep
open class BaseRequest {
  @Transient
  var image: ArrayList<MultipartBody.Part> = arrayListOf()
  fun setImage(path: String, key: String){
    val file = File(path)
    val requestFile: RequestBody = RequestBody.create(
      "multipart/form-data".toMediaTypeOrNull(),
      file
    )
    image.add(MultipartBody.Part.createFormData(key, file.name, requestFile))
  }
}