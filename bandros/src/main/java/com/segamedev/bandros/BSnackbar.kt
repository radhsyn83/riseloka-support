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

class BSnackbar(private val mContext: Context) {

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun primary(textResource: Int, length: Int = Snackbar.LENGTH_SHORT) {
        custom(textResource, bgColor = R.color.bsnackbar_primary, length = length)
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun success(textResource: Int, length: Int = Snackbar.LENGTH_SHORT) {
        custom(textResource, bgColor = R.color.bsnackbar_success, length = length)
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun info(textResource: Int, length: Int = Snackbar.LENGTH_SHORT) {
        custom(textResource, bgColor = R.color.bsnackbar_info, length = length)
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun warning(textResource: Int, length: Int = Snackbar.LENGTH_SHORT) {
        custom(textResource, bgColor = R.color.bsnackbar_warning, length = length)
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun danger(textResource: Int, length: Int = Snackbar.LENGTH_SHORT) {
        custom(textResource, bgColor = R.color.bsnackbar_danger, length = length)
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param textResource The string resource to display as the title.
     * @param length Snackbar.LENGTH_SHORT or Snackbar.LENGTH_LONG or Snackbar.LENGTH_INDEFINITE
     */
    fun custom(textResource: Int,
               icon: Int = R.drawable.bsnackbar_icon,
               iconColor: Int? = null,
               bgColor: Int = R.color.bsnackbar_info,
               textColor: Int = android.R.color.white,
               length: Int = Snackbar.LENGTH_SHORT)
    {
        val rootView = (mContext as Activity)
            .window.decorView.findViewById<View>(android.R.id.content)

        val snackBar = Snackbar.make(rootView, "", length)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)

        //inflate view
        val customView = mContext.layoutInflater.inflate(R.layout.snackbar_custom, null)
        val snackBarView = snackBar.view as Snackbar.SnackbarLayout
        snackBarView.setPadding(0, 0, 0, 0)

        customView.findViewById<TextView>(R.id.message).text = mContext.getString(textResource)
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
        snackBar.show()
    }

}