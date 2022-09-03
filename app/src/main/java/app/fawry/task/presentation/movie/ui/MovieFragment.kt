package app.fawry.task.presentation.movie.ui

import androidx.navigation.fragment.navArgs
import app.fawry.task.presentation.base.BaseFragment
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(){

  private  val TAG = "MovieFragment"
  /** get selected parcelable movie from previous list**/
  private val args : MovieFragmentArgs by navArgs()

  override
  fun getLayoutId() = R.layout.fragment_movie

  override
  fun setBindingVariables() {
    binding.movie = args.movie
  }
}