package app.fawry.task.domain.category.use_case

import android.util.Log
import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryLocalRepository
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class CategoryUseCase @Inject constructor(
  private val repository: CategoryRemoteRepository,
  private val repositoryLocal: CategoryLocalRepository
) {
  private  val TAG = "CategoryUseCase"
  /**
   * invoke function will be call directly
   * */
  operator fun invoke(): Flow<Resource<CategoryResponse>> = flow {

    emit(Resource.Loading) //show loader
    val result = repository.getCategories() //call api categories
    if (result is Resource.Success) {
      Log.d(TAG, "invoke: DONE")
      repositoryLocal.insert(result.value.categories)
    }
    emit(result)//send result for collecting
  }.flowOn(Dispatchers.IO)
}