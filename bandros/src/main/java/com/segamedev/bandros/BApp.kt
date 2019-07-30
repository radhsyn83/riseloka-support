package com.segamedev.bandros

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager

//
// Created by Fathur Radhy 
// on July 2019-07-10.
//
object BApp {
    fun hideKeyboardFrom(context: Context, rootView: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(rootView.windowToken, 0)
    }

    fun intToFloat(intVal: Int): Float {
        var floatVal = 0.0f
        floatVal = 1f * intVal
        return floatVal
    }

    /**
     * Shows a title, or header, at the top of the dialog.
     *
     * @param isTransparent If TRUE, the statusBar will disappear.
     * @param lightStatusBar TRUE = Light, FALSE = Dark
     */
    fun customStatusBar(activity: Activity, isTransparent: Boolean, color: Int = Color.WHITE, lightStatusBar: Boolean = false) {
        if (isTransparent) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            activity.window.statusBarColor = Color.TRANSPARENT
        } else {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            activity.window.statusBarColor = color
        }

        if (lightStatusBar) {
            var flags = activity.window.decorView.systemUiVisibility // get current flag
            flags =
                flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // use XOR here for remove LIGHT_STATUS_BAR from flags
            activity.window.decorView.systemUiVisibility = flags
        }
    }
}