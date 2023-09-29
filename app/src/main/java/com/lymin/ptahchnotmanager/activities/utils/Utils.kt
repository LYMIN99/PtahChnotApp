package com.lymin.ptahchnotmanager.activities.utils

import android.util.Log
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Utils {
    companion object {
        fun getYesterday(): String {

            val currentDate = LocalDate.now()
            val yesterday = currentDate.minusDays(1)
            val date = LocalDate.of(currentDate.year, currentDate.month, yesterday.dayOfMonth)
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            return date.format(formatter)
        }
    }
}