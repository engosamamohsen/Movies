package app.fawry.task.presentation.movie.ui

import androidx.navigation.fragment.navArgs
import app.fawry.task.presentation.base.BaseFragment
import app.fawry.task.presentation.movie.ui_state.MovieUIState
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(){

  /** get selected parcelable movie from previous list**/
  private val args : MovieFragmentArgs by navArgs()

  override
  fun getLayoutId() = R.layout.fragment_movie

  override
  fun setBindingVariables() {
    binding.movie = MovieUIState(args.movie)
  }
}