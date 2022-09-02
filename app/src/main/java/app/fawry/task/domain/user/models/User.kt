package app.fawry.task.domain.user.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class User(
  @SerializedName("email")
  @Expose val email: String = "",
  @SerializedName("id")
  @Expose val id: Int = 0,
  @SerializedName("name")
  @Expose val name: String = "",
  @SerializedName("phone")
  @Expose val phone: String = "",
)