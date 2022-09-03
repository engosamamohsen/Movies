package app.fawry.task.domain.category.entity

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Category(
  @SerializedName("id")
  @Expose val id: Int = 0,
  @SerializedName("name")
  @Expose val name: String = ""
)