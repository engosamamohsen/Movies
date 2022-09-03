package app.fawry.task.presentation.home.list.viewModels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.use_case.CategoryUseCase
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.BaseViewModel
import app.fawry.task.presentation.home.list.adapter.CategoriesAdapter
import com.structure.base_mvvm.BR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val useCase: CategoryUseCase
) : BaseViewModel() {

  /** collect categories api for listening in fragment **/
  val categoryResponse = MutableStateFlow<Resource<CategoryResponse>>(Resource.Default)
  @Bindable
  val adapter = CategoriesAdapter()
  init {
    getCategories()
  }

  /** Get Categories Api using useCase invoke function **/
  private fun getCategories() {
    useCase().onEach {
      categoryResponse.value = it
    }.launchIn(viewModelScope)
  }

  /**update data in adapter**/
  fun setData(categories: List<Category>) {
    adapter.update(categories)
    notifyPropertyChanged(BR.adapter)
  }


}