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
  @ColumnInfo(name = "details")
  var details: String = "",
  @SerializedName("adult")
  @Ignore
  @Expose val adult: Boolean = false,
  @SerializedName("backdrop_path")
  @Ignore
  @Expose val backdropPath: String = "",
  @SerializedName("genre_ids")
  @Ignore
  @Expose val genreIds: List<Int> = listOf(),
  @SerializedName("original_language")
  @Ignore
  @Expose val originalLanguage: String = "",
  @SerializedName("original_title")
  @Ignore
  @Expose val originalTitle: String = "",
  @SerializedName("overview")
  @Ignore
  @Expose var overview: String = "",
  @SerializedName("popularity")
  @Ignore
  @Expose var popularity: Double = 0.0,
  @SerializedName("poster_path")
  @Ignore
  @Expose var posterPath: String = "",
  @SerializedName("release_date")
  @Ignore
  @Expose var releaseDate: String = "",
  @SerializedName("title")
  @Ignore
  @Expose var title: String = "",
  @SerializedName("video")
  @Ignore
  @Expose val video: Boolean = false,
  @SerializedName("vote_average")
  @Ignore
  @Expose var voteAverage: Double = 0.0,
  @SerializedName("vote_count")
  @Ignore
  @Expose var voteCount: Int = 0
) : Parcelable