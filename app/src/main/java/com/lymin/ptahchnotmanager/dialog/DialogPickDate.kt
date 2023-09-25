package com.lymin.ptahchnotmanager.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.ImageButton
import com.lymin.ptahchnotmanager.R
import java.text.SimpleDateFormat
import java.util.*

class DialogPickDate(private val context: Context, private val onCallBack: OnCallBack) {
    init {
        initialize()
    }

    private fun initialize() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR) // before
        dialog.setContentView(R.layout.dialog_select_date)
        Objects.requireNonNull(dialog.window)!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(Objects.requireNonNull(dialog.window)!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lp
        val btnClose = dialog.findViewById<ImageButton>(R.id.btn_close)
        val btnConfirm = dialog.findViewById<Button>(R.id.btn_confirm)
        val datePicker1: DatePicker = dialog.findViewById<DatePicker>(R.id.date_picker_1)
        val datePicker2: CalendarView = dialog.findViewById<CalendarView>(R.id.date_picker_2)
        btnClose.setOnClickListener { v: View? -> dialog.dismiss() }
        val date = arrayOf("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker1.setVisibility(View.VISIBLE)
            datePicker2.setVisibility(View.GONE)
            datePicker1.setOnDateChangedListener(object : DatePicker.OnDateChangedListener {
                override fun onDateChanged(
                    view: DatePicker,
                    year: Int,
                    monthOfYear: Int,
                    dayOfMonth: Int
                ) {
                    // date[0] = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;;
                    val month =
                        if (monthOfYear + 1 < 10) "0" + (monthOfYear + 1) else (monthOfYear + 1).toString() + ""
                    val day = if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString() + ""
                    date[0] = "$year-$month-$day"
                }
            })
        } else {
            datePicker1.setVisibility(View.GONE)
            datePicker2.setVisibility(View.VISIBLE)
            datePicker2.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {
                override fun onSelectedDayChange(
                    view: CalendarView,
                    year: Int,
                    month: Int,
                    dayOfMonth: Int
                ) {
                    val monthx =
                        if (month + 1 < 10) "0" + (month + 1) else (month + 1).toString() + ""
                    val day = if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString() + ""
                    date[0] = "$year-$monthx-$day"

                    //    date[0] = dayOfMonth+"/"+(month+1)+"/"+year;;
                    //date[0] = year + "-" + (month + 1) + "-" + dayOfMonth;
                }
            })
        }
        btnConfirm.setOnClickListener { v: View? ->
            if (date[0] == "") {
                val d = Calendar.getInstance().time
                @SuppressLint("SimpleDateFormat") val formatter = SimpleDateFormat("dd/MM/yyyy")
                date[0] = formatter.format(d)
            }
            onCallBack.onConfirmClick(date[0])
            dialog.dismiss()
        }
        dialog.setOnDismissListener { dialog -> dialog.dismiss() }
        dialog.show()
    }

    interface OnCallBack {
        fun onConfirmClick(value: String?)
    }
}