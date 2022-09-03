package app.fawry.task.domain.category.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryResponse {
  @SerializedName("genres")
  @Expose
  val categories: List<Category> = arrayListOf()
}