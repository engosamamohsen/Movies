package app.fawry.task.domain.category.repository
import app.fawry.task.domain.category.entity.Category
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.movie.entity.Movie
import app.fawry.task.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryLocalRepository {
  suspend fun getCategories(): Flow<List<Category>>
  suspend fun insert(list: List<Category>)
}