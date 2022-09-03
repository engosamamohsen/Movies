package app.fawry.task.data.category.repository

import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryRepository
import app.fawry.task.domain.utils.Resource
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val remoteDataSource: CategoryRemoteDataSource) :
  CategoryRepository {
  override suspend fun getCategories(): Resource<CategoryResponse> = remoteDataSource.getCategories()

}