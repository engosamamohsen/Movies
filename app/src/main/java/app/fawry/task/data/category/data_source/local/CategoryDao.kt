package app.fawry.task.data.category.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.fawry.task.domain.category.entity.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {
  @Query("Select * from category")
  fun getCategories(): Flow<List<Category>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(order: List<Category>)
}