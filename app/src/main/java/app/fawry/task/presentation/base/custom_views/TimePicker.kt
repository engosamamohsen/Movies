package app.fawry.task.presentation.base.custom_views

import android.app.TimePickerDialog
import android.content.Context
import android.util.AttributeSet
import android.widget.TimePicker
import app.fawry.task.presentation.base.utils.DateUtils
import java.text.SimpleDateFormat
import java.util.*

class TimePicker(context: Context, attrs: AttributeSet) :
  androidx.appcompat.widget.AppCompatTextView(context, attrs) {

  init {
    setOnClickListener { showDialog() }
  }

  private fun showDialog() {
    val calendar = Calendar.getInstance()
    val format = SimpleDateFormat(DateUtils.TIME_24_FORMAT, Locale("en"))
    TimePickerDialog(
      context,
      { _: TimePicker?, hourOfDay: Int, minute: Int ->
        calendar[Calendar.HOUR_OF_DAY] = hourOfDay
        calendar[Calendar.MINUTE] = minute
        val strDate: String = format.format(calendar.time)
        text = strDate
      }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false
    ).show()

  }
}