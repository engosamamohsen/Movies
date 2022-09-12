package app.fawry.task.presentation.home.list.viewModels

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import androidx.work.ListenableWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkRequest
import app.fawry.task.data.background.ServiceApiManager
import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.data.movie.data_source.local.MovieLocalDataSource
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
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.internal.wait
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val useCase: CategoryUseCase,
  private val movieUseCase: MovieUseCase,
  private val categoryLocalDataSource: CategoryLocalDataSource,
  private val movieLocalDataSource: MovieLocalDataSource,
  val workRequest: PeriodicWorkRequest
) : BaseViewModel() {
  private val TAG = "HomeViewModel"

  /** collect categories api for listening in fragment **/
  val categoryResponse = MutableStateFlow<Resource<CategoryResponse>>(Resource.Default)

  /** collect movies api for listening in fragment **/
  val movieResponse = MutableStateFlow<Resource<MovieResponse>>(Resource.Default)

  @Bindable
  val adapter = CategoriesAdapter()

  @Bindable
  val adapterMovies = MoviesAdapter()

  init {
    viewModelScope.launch(Dispatchers.IO) {
      movieLocalDataSource.count().collect {//check data is cached before
        Log.d(TAG, "count: $it")
        when (it) {
          0 -> {
            getCategories() //call categories api
            getMovies()//call movies api
          }
          else -> getLocalData() // get data from local cache
        }
      }
    }
  }

  private fun getLocalData() {
    viewModelScope.launch(Dispatchers.IO) {
      categoryLocalDataSource.getCategories().collect {
        Log.d(TAG, "getCategories: ${it.size}")
        setData(it)
      }
    }
    viewModelScope.launch(Dispatchers.IO) {
      movieLocalDataSource.getMovies().collect {
        updateMovies(it)
      }
    }
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
    adapterMovies.update(movies)
    notifyPropertyChanged(BR.adapterMovies)
  }


}