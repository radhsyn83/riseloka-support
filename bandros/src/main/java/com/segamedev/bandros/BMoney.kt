package com.segamedev.bandros

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.lang.Double.parseDouble
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

//
// Created by Fathur Radhy 
// on July 2019-07-08.
//
object BMoney {

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param value ex: 100000 will return Rp10.000
     */
    fun toRupiah(value: String): String {
        return "Rp" + DecimalFormat("#,###,###")
            .format(parseDouble(value))
            .replace(",".toRegex(), ".")
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param value ex: 100000 will return Rp10rb
     */
    fun toRupiahRibuan(value: String): String {
        val nom = (value.toInt() / 1000).toString()
        val formatter = DecimalFormat("#,###,###")
        val converted = formatter.format(parseDouble(nom)).replace(",".toRegex(), ".")
        return "Rp " + converted + "rb"
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param value ex: 100000 will return 10.0000
     */
    fun normal(value: String): String {
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(parseDouble(value)).replace(",".toRegex(), ".")
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * auto convert to money format on EditText
     */
    fun numberFormatWatcher(context: Context, editText: EditText) : TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                editText.removeTextChangedListener(this)

                try {
                    var originalString = s.toString()

                    val longval: Long?
                    if (originalString.contains(",")) {
                        originalString = originalString.replace(",".toRegex(), "")
                    }
                    longval = java.lang.Long.parseLong(originalString)

                    val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
                    formatter.applyPattern("#,###,###,###")
                    val formattedString = formatter.format(longval)

                    //setting text after format to EditText
                    editText.setText(formattedString)
                    editText.setSelection(editText.text.length)
                } catch (nfe: NumberFormatException) {
                    nfe.printStackTrace()
                }

                editText.addTextChangedListener(this)            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param numberFormat from 10,000 will return 100000
     */
    fun numberFormatToString(numberFormat: String) : String {
        return numberFormat.replace(",".toRegex(), "")
    }
}