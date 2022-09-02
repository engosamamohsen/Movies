package app.fawry.task.presentation.home.list.viewModels

import app.fawry.task.domain.user.models.User
import app.fawry.task.domain.user.use_case.HomeUseCase
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val useCase: HomeUseCase
) : BaseViewModel() {

  val usersResponse =
    MutableStateFlow<Resource<List<User>>>(Resource.Default)

  init {
  }


}