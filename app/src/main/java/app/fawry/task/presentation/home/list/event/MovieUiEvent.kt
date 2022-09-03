package app.fawry.task.presentation.home.list.event

import app.fawry.task.domain.movie.entity.Movie

/**
 * Warning: It's bad practice to pass the ViewModel into the RecyclerView adapter
 * because that tightly couples the adapter with the ViewModel class.
 *
 * Note: Another common pattern is for the RecyclerView adapter to have a Callback interface for user actions. In that case,
 * the activity or fragment can handle the binding and call the ViewModel functions directly from the callback interface.
 *
 * More Details
 * https://developer.android.com/topic/architecture/ui-layer/events#views_1
 * **/
interface MovieUiEvent {
  fun submitMovie(movie: Movie)
}