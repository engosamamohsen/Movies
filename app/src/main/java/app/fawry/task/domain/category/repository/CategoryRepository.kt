package app.fawry.task.domain.category.repository
import app.fawry.task.domain.category.entity.CategoryResponse
import app.fawry.task.domain.utils.Resource

interface CategoryRepository {
  suspend fun getCategories(): Resource<CategoryResponse>
}