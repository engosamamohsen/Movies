package app.fawry.task.domain.movie.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResponse {
  @SerializedName("results")
  @Expose
  val movies: List<Movie> = arrayListOf()
}