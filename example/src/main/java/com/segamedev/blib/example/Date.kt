package com.segamedev.blib.example

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.segamedev.bandros.BDate
import kotlinx.android.synthetic.main.activity_date.*
import java.text.SimpleDateFormat
import java.util.*


class Date : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        tv_normal.text = BDate.dateFormat(dateNow())
        tv_one.text = BDate.dateFormatCustom(dateNow())
        tv_two.text = BDate.dateFormatCustom(yesterday(-1))
        tv_three.text = BDate.dateFormatCustom(yesterday(-2))
    }

    @SuppressLint("SimpleDateFormat")
    private fun dateNow(): String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, 0)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(cal.time)
    }

    @SuppressLint("SimpleDateFormat")
    private fun yesterday(amount: Int): String {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, amount)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(cal.time)
    }
}
