package app.fawry.task.data.category.data_source.local

import app.fawry.task.data.remote.BaseRemoteDataSource
import app.fawry.task.domain.category.entity.Category
import javax.inject.Inject

class CategoryLocalDataSource @Inject constructor(private val dao: CategoryDao) :
  BaseRemoteDataSource() {
  suspend fun getCategories() = safeApiCall {
    dao.getCategories()
  }

  suspend fun insert(list: List<Category>) = safeApiCall {
    dao.insert(list)
  }

}