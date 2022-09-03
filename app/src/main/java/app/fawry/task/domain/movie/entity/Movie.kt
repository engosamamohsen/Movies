package app.fawry.task.domain.movie.entity


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import java.io.Serializable

@Keep
data class Movie(
  @SerializedName("adult")
    @Expose val adult: Boolean = false,
  @SerializedName("backdrop_path")
    @Expose val backdropPath: String = "",
  @SerializedName("genre_ids")
    @Expose val genreIds: List<Int> = listOf(),
  @SerializedName("id")
    @Expose var id: Int = 0,
  @SerializedName("original_language")
    @Expose val originalLanguage: String = "",
  @SerializedName("original_title")
    @Expose val originalTitle: String = "",
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
    @Expose val video: Boolean = false,
  @SerializedName("vote_average")
    @Expose var voteAverage: Double = 0.0,
  @SerializedName("vote_count")
    @Expose var voteCount: Int = 0
) : Parcelable{
  constructor(parcel: Parcel) : this() {
    title = parcel.readString().toString()
    posterPath = parcel.readString().toString()
    releaseDate = parcel.readString().toString()
    overview = parcel.readString().toString()
    voteAverage = parcel.readDouble()
    popularity = parcel.readDouble()
    voteCount = parcel.readInt()
    id = parcel.readInt()
  }

  override fun describeContents(): Int {
    return 0
  }

  override fun writeToParcel(p0: Parcel?, p1: Int) {
    p0?.apply {
      this.writeString(title)
      this.writeString(posterPath)
      this.writeString(releaseDate)
      this.writeString(overview)
      this.writeDouble(voteAverage)
      this.writeDouble(popularity)
      this.writeInt(voteCount)
      this.writeInt(id)
    }
  }

  companion object CREATOR : Parcelable.Creator<Movie> {
    override fun createFromParcel(parcel: Parcel): Movie {
      return Movie(parcel)
    }

    override fun newArray(size: Int): Array<Movie?> {
      return arrayOfNulls(size)
    }
  }

}