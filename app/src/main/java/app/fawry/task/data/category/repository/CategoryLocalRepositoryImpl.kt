package app.fawry.task.data.category.repository

import app.fawry.task.data.category.data_source.local.CategoryLocalDataSource
import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryLocalRepository
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryLocalRepositoryImpl @Inject constructor(private val localDataSource: CategoryLocalDataSource) :
  CategoryLocalRepository {
  override suspend fun getCategories(): Flow<List<Category>>  = localDataSource.getCategories()

  override suspend fun insert(list: List<Category>){
    localDataSource.insert(list)
  }

}