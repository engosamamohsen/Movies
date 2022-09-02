package app.fawry.task.data.local.preferences

import android.content.Context
import javax.inject.Inject

class AppPreferences @Inject constructor(private val context: Context) {

  private val STORE_NAME = "app_data_store"
  private val STORE_NAME_FIRST_TIME = "app_data_store_first_time"
}