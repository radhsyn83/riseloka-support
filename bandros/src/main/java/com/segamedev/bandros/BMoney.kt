package com.segamedev.bandros

import java.lang.Double.parseDouble
import java.text.DecimalFormat

//
// Created by Fathur Radhy 
// on July 2019-07-08.
//
object BMoney {
    fun toRupiah(value: String): String {
        return "Rp" + DecimalFormat("#,###,###")
            .format(parseDouble(value))
            .replace(",".toRegex(), ".")
    }

    fun toRupiahRibuan(value: String): String {
        val nom = (value.toInt() / 1000).toString()
        val formatter = DecimalFormat("#,###,###")
        val converted = formatter.format(parseDouble(nom)).replace(",".toRegex(), ".")
        return "Rp " + converted + "rb"
    }

    fun normal(value: String): String {
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(parseDouble(value)).replace(",".toRegex(), ".")
    }
}