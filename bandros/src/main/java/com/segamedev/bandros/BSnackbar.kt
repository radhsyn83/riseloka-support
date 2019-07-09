package com.segamedev.bandros

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

//
// Created by Fathur Radhy 
// on July 2019-07-08.
//
class BSnackbar(val mContext: Context) {

    fun primary(text: String, length: Int = Snackbar.LENGTH_SHORT) {
        custom(text, bgColor = R.color.bsnackbar_primary, lenght = length)
    }

    fun success(text: String, length: Int = Snackbar.LENGTH_SHORT) {
        custom(text, bgColor = R.color.bsnackbar_success, lenght = length)
    }

    fun info(text: String, length: Int = Snackbar.LENGTH_SHORT) {
        custom(text, bgColor = R.color.bsnackbar_info, lenght = length)
    }

    fun warning(text: String, length: Int = Snackbar.LENGTH_SHORT) {
        custom(text, bgColor = R.color.bsnackbar_warning, lenght = length)
    }

    fun danger(text: String, length: Int = Snackbar.LENGTH_SHORT) {
        custom(text, bgColor = R.color.bsnackbar_danger, lenght = length)
    }

    fun custom(text: String,
              icon: Int = R.drawable.bsnackbar_icon,
              iconColor: Int? = null,
              bgColor: Int = R.color.bsnackbar_info,
              textColor: Int = android.R.color.white,
              lenght: Int = Snackbar.LENGTH_SHORT)
    {
        val rootView = (mContext as Activity)
            .window.decorView.findViewById<View>(android.R.id.content)

        val snackbar = Snackbar.make(rootView, "", lenght)
        snackbar.view.setBackgroundColor(Color.TRANSPARENT)

        //inflate view
        val customView = mContext.layoutInflater.inflate(R.layout.snackbar_custom, null)
        val snackBarView = snackbar.view as Snackbar.SnackbarLayout
        snackBarView.setPadding(0, 0, 0, 0)

        customView.findViewById<TextView>(R.id.message).text = text
        customView.findViewById<TextView>(R.id.message)
            .setTextColor(ContextCompat.getColor(mContext, textColor))
        customView.findViewById<ImageView>(R.id.icon).setImageResource(icon)
        customView.findViewById<CardView>(R.id.parent)
            .setCardBackgroundColor(ContextCompat.getColor(mContext, bgColor))
        snackBarView.addView(customView, 0)
        if (iconColor != null) {
            ImageViewCompat.setImageTintList(
                customView.findViewById<ImageView>(R.id.icon),
                ColorStateList.valueOf(iconColor))
        }
        snackbar.show()
    }

}