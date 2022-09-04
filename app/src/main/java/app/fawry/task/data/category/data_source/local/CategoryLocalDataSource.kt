package app.fawry.task.data.category.data_source.local

import app.fawry.task.data.remote.BaseRemoteDataSource
import app.fawry.task.domain.category.entity.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryLocalDataSource @Inject constructor(private val dao: CategoryDao) :
  BaseRemoteDataSource() {
  fun getCategories() = dao.getCategories()

  suspend fun insert(list: List<Category>) = safeApiCall {
    withContext(Dispatchers.IO) {
      dao.insert(list)
      cancel()
    }
  }

}