package app.fawry.task.data.background

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import app.fawry.task.domain.movie.repository.MovieLocalRepository
import app.fawry.task.domain.movie.repository.MovieRemoteRepository
import app.fawry.task.domain.movie.use_case.MovieUseCase
import app.fawry.task.domain.utils.Resource
import app.fawry.task.presentation.base.utils.Constants
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach

@HiltWorker
class ServiceApiManager @AssistedInject constructor(
  @Assisted context: Context,
  @Assisted workerParams: WorkerParameters,
  private val repository: MovieRemoteRepository,
  private val repositoryLocal : MovieLocalRepository
  ) :
  CoroutineWorker(context, workerParams) {
  private val TAG = "ServiceApiManager"
  lateinit var result: Result
  override suspend fun doWork(): Result {
    result = Result.failure()
    Log.d(TAG, "doWork: WORKED")
    return when(val result = repository.getMovies()){
      is Resource.Success -> {
        Log.d(TAG, "doWork: ${result.value.movies.size}")
        result.value.movies.map {
          it.posterPath = Constants.IMAGE_PATH + it.posterPath
        }
        repositoryLocal.insert(result.value.movies)
        Result.success()
      }
      is Resource.Failure -> Result.failure()
      else -> Result.failure()
    }
  }
}