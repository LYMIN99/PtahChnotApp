package com.lymin.ptahchnotapp.activities.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Utils {
    companion object {
        fun getYesterday(): String {

            val currentDate = LocalDate.now()
            val yesterday = currentDate.minusDays(1)
          //  val date = LocalDate.of(currentDate.year, currentDate.month, yesterday.dayOfMonth)
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            return yesterday.format(formatter)
        }
        fun getDay(day : Long): String {

            val currentDate = LocalDate.now()
            val day = currentDate.minusDays(day)
          //  val date = LocalDate.of(currentDate.year, currentDate.month, yesterday.dayOfMonth)
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            return day.format(formatter)
        }
    }
}