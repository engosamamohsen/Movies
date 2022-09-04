package app.fawry.task.domain.movie.entity


import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/** room movie structure(roomId - id - details [string of object movie]) **/
@Entity(tableName = "movie")
@Keep
@Parcelize
data class Movie(
  @PrimaryKey(autoGenerate = true)
  var roomId: Int = 0,
  @SerializedName("id")
  @ColumnInfo(name = "id")
  @Expose var id: Int = 0,
  @SerializedName("adult")
  @Expose var adult: Boolean = false,
  @SerializedName("backdrop_path")
  @Expose var backdropPath: String = "",
  @SerializedName("genre_ids")
  @Ignore
  @Expose var genreIds: List<Int> = listOf(),
  @SerializedName("original_language")
  @Expose var originalLanguage: String = "",
  @SerializedName("original_title")
  @Expose var originalTitle: String = "",
  @SerializedName("overview")
  @Expose var overview: String = "",
  @SerializedName("popularity")
  @Expose var popularity: Double = 0.0,
  @SerializedName("poster_path")
  @Expose var posterPath: String = "",
  @SerializedName("release_date")
  @Expose var releaseDate: String = "",
  @SerializedName("title")
  @Expose var title: String = "",
  @SerializedName("video")
  @Expose var video: Boolean = false,
  @SerializedName("vote_average")
  @Expose var voteAverage: Double = 0.0,
  @SerializedName("vote_count")
  @Expose var voteCount: Int = 0
) : Parcelable