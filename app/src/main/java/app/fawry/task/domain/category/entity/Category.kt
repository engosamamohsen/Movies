package app.fawry.task.domain.category.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/** room category structure(roomId - id - name) **/
@Entity(tableName = "category")
@Keep
data class Category(
  @PrimaryKey(autoGenerate = true)
  val roomId: Int? = null,
  @SerializedName("id")
  @ColumnInfo(name = "id")
  @Expose val id: Int = 0,
  @SerializedName("name")
  @ColumnInfo(name = "name")
  @Expose val name: String = ""
)