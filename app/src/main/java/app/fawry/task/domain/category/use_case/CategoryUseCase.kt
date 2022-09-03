package app.fawry.task.domain.category.use_case

import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryRepository
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class CategoryUseCase @Inject constructor(
  private val repository: CategoryRepository
) {
  /**
   * invoke function will be call directly
   * */
  operator fun invoke(): Flow<Resource<CategoryResponse>> = flow {

    emit(Resource.Loading) //show loader
    val result = repository.getCategories() //call api categories
    if (result is Resource.Success) {
      //receive data if success
    }
    emit(result)//send result for collecting
  }.flowOn(Dispatchers.IO)
}