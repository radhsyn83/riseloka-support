package com.segamedev.bandros

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

//
// Created by Fathur Radhy 
// on July 2019-07-08.
//
@SuppressLint("SimpleDateFormat")
object BDate {
    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param time Date format must be "yyyy-MM-dd HH:mm:ss"
     */
    fun dateFormat(time: String): String {
        var dateTime: Date? = null
        try {
            dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat("dd/MM/yyyy HH:mm").format(dateTime) + ", " + SimpleDateFormat("HH:mm").format(
            dateTime
        ) + " WIB"
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param time Date format must be "yyyy-MM-dd HH:mm:ss"
     */
    fun dateFormatCustom(time: String): String {
        var dateTime: Date? = null
        var dateTime2: Date? = null
        try {
            dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val calendar = Calendar.getInstance()
        calendar.time = dateTime

        val today = Calendar.getInstance()
        val yesterday = Calendar.getInstance()
        yesterday.add(Calendar.DATE, -1)

        try {
            dateTime2 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val calendar2 = Calendar.getInstance()
        calendar2.time = dateTime2

        return if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(
                Calendar.DAY_OF_YEAR
            )
        ) {
            SimpleDateFormat("HH:mm").format(dateTime)
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(
                Calendar.DAY_OF_YEAR
            ) == yesterday.get(
                Calendar.DAY_OF_YEAR
            )
        ) {
            "Kemarin, " + SimpleDateFormat("HH:mm").format(dateTime)
        } else {
            SimpleDateFormat("dd/MM/yyyy").format(dateTime) + ", " + SimpleDateFormat("HH:mm").format(
                dateTime
            )
        }
    }

    fun datePicker(mContext: Context, onGetDate: (String) -> Unit) {

        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "yyyy-MM-dd" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            onGetDate(sdf.format(cal.time))
        }

        DatePickerDialog(mContext, dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)).show()
    }
}