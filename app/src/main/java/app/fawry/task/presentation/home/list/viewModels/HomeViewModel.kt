package app.fawry.task.presentation.home.list.viewModels

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.use_case.CategoryUseCase
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.movie.entity.MovieResponse
import app.fawry.task.domain.movie.use_case.MovieUseCase
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.BaseViewModel
import app.fawry.task.presentation.home.list.adapter.CategoriesAdapter
import app.fawry.task.presentation.home.list.adapter.MoviesAdapter
import com.structure.base_mvvm.BR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val useCase: CategoryUseCase,
  private val movieUseCase: MovieUseCase
) : BaseViewModel() {
  private val TAG = "HomeViewModel"
  /** collect categories api for listening in fragment **/
  val categoryResponse = MutableStateFlow<Resource<CategoryResponse>>(Resource.Default)
  val movieResponse = MutableStateFlow<Resource<MovieResponse>>(Resource.Default)
  @Bindable
  val adapter = CategoriesAdapter()
  @Bindable
  val adapterMovies = MoviesAdapter()

  init {
    getCategories()
    getMovies()
  }

  /** Get Categories Api using useCase invoke function **/
  private fun getCategories() {
    useCase().onEach {
      categoryResponse.value = it
    }.launchIn(viewModelScope)
  }

  /** Get Categories Api using useCase invoke function **/
  private fun getMovies() {
    movieUseCase()
      .onEach {
      movieResponse.value = it
    }.launchIn(viewModelScope)
  }

  /**update data in category adapter**/
  fun setData(categories: List<Category>) {
    adapter.update(categories)
    notifyPropertyChanged(BR.adapter)
  }

  /**update data in movies adapter**/
  fun updateMovies(movies: List<Movie>) {
    Log.d(TAG, "updateMovies: DONE ${movies.size}")
    adapterMovies.update(movies)
    notifyPropertyChanged(BR.adapterMovies)
  }


}