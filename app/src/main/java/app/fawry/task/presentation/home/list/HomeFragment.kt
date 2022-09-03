package app.fawry.task.presentation.home.list

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.utils.Resource
import com.structure.base_mvvm.R
import app.fawry.task.presentation.base.BaseFragment
import app.fawry.task.presentation.base.extensions.handleApiError
import app.fawry.task.presentation.base.extensions.hideKeyboard
import app.fawry.task.presentation.base.utils.showMessage
import app.fawry.task.presentation.home.list.event.MovieUiEvent
import app.fawry.task.presentation.home.list.viewModels.HomeViewModel
import com.structure.base_mvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() , MovieUiEvent{

  private  val TAG = "HomeFragment"

  private val viewModel: HomeViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_home

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
    viewModel.adapterMovies.movieUIEvent = this
  }
  override fun setupObservers() {
    super.setupObservers()
    //listen for categories api
    lifecycleScope.launchWhenResumed {
      viewModel.categoryResponse
        .collect {
        when (it) {
          Resource.Loading -> {
            hideKeyboard()
            showLoading()
          }
          is Resource.Success -> {

            hideLoading()
            viewModel.setData(it.value.categories)
          }
          is Resource.Failure -> {
            hideLoading()
            handleApiError(it)
          }
          else -> {}
        }
      }
    }

    //listen for movies api
    lifecycleScope.launchWhenResumed {
      viewModel.movieResponse
        .collect {
        when (it) {
          Resource.Loading -> {
            hideKeyboard()
            showLoading()
          }
          is Resource.Success -> {
            hideLoading()
            viewModel.updateMovies(it.value.movies)
          }
          is Resource.Failure -> {
            hideLoading()
            handleApiError(it)
          }
          else -> {}
        }
      }
    }

  }

  override fun submitMovie(movie: Movie) {
    Log.d(TAG, "submitMovie: ${movie.id}")
    showMessage(requireContext(),"${movie.id}")
  }
}