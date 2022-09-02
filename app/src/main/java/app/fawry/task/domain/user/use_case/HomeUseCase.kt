package app.fawry.task.domain.user.use_case

import app.fawry.task.domain.user.repository.HomeRepository
import javax.inject.Inject


class HomeUseCase @Inject constructor(
  private val usersRepository: HomeRepository
) {

}