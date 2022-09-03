package app.fawry.task.presentation.movie.ui_state

import android.content.Context
import app.fawry.task.domain.movie.entity.Movie
import com.structure.base_mvvm.R
/**
 * carry ui represent in movie screen
 * https://developer.android.com/topic/architecture/ui-layer
 * **/
class MovieUIState(val movie: Movie) {

  fun getMovieTitle():String = movie.title

  fun getMoviePosterPath(): String = movie.posterPath

  fun getMovieOverview(): String = movie.overview

  fun getMovieReleaseDate(context: Context): String = "${context.getString(R.string.release)} ${movie.releaseDate}"
}