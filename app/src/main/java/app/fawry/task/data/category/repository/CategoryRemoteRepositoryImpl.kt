package app.fawry.task.data.category.repository

import app.fawry.task.data.category.data_source.remote.CategoryRemoteDataSource
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.category.repository.CategoryRemoteRepository
import app.fawry.task.domain.utils.Resource
import javax.inject.Inject

class CategoryRemoteRepositoryImpl @Inject constructor(private val remoteDataSource: CategoryRemoteDataSource) :
  CategoryRemoteRepository {
  override suspend fun getCategories(): Resource<CategoryResponse> = remoteDataSource.getCategories()

}