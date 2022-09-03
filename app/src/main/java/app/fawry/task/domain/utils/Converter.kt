package app.fawry.task.domain.utils

import androidx.room.TypeConverter
import app.fawry.task.domain.category.entity.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
  @TypeConverter
  fun fromClassesString(value: String): List<Category> {
    val listType: Type = object : TypeToken<List<Category>>() {}.type
    return Gson().fromJson(value, listType)
  }

  @TypeConverter
  fun fromClassesList(list: List<Category>): String {
    val gson = Gson()
    return gson.toJson(list)
  }
}