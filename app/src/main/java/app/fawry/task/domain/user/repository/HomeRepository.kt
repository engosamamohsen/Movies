package app.fawry.task.domain.user.repository
import app.fawry.task.domain.user.models.User
import app.fawry.task.domain.utils.Resource

interface HomeRepository {
  suspend fun users(): Resource<List<User>>
}