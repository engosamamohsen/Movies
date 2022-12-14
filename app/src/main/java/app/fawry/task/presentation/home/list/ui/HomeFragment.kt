package app.fawry.task.presentation.home.list.ui

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.BaseFragment
import app.fawry.task.presentation.base.extensions.handleApiError
import app.fawry.task.presentation.base.extensions.hideKeyboard
import app.fawry.task.presentation.base.extensions.setUpAdapter
import app.fawry.task.presentation.home.list.event.MovieUiEvent
import app.fawry.task.presentation.home.list.viewModels.HomeViewModel
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() , MovieUiEvent{

  private  val TAG = "HomeFragment"

  private val viewModel: HomeViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_home

  override
  fun setBindingVariables() {
    Log.d(TAG, "setBindingVariables: ")
    initWorkManager()
    viewModel.adapterMovies.movieUIEvent = this
    binding.rvCategories.setUpAdapter(viewModel.adapter,"1","2")
    binding.rvMovies.setUpAdapter(viewModel.adapterMovies,"2","1")
  }

  //add work-manager for cache movies
  private fun initWorkManager() {
    WorkManager.getInstance(requireContext()).enqueueUniquePeriodicWork(
      "movieWorkManager",
      ExistingPeriodicWorkPolicy.KEEP,
      viewModel.workRequest
    )
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
              //update categories in adapter
//              viewModel.setData(it.value.categories)
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
              //update movies in adapter
//              viewModel.updateMovies(it.value.movies)
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
    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieFragment(movie))
  }
}