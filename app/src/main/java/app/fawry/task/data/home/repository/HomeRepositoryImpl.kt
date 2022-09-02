package app.fawry.task.data.home.repository

import app.fawry.task.data.home.data_source.remote.HomeRemoteDataSource
import app.fawry.task.domain.user.models.User
import app.fawry.task.domain.user.repository.HomeRepository
import app.fawry.task.domain.utils.Resource
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val remoteDataSource: HomeRemoteDataSource) :
  HomeRepository {
  override suspend fun users(): Resource<List<User>> = remoteDataSource.users()

}