package com.segamedev.riseloka

import java.util.regex.Matcher
import java.util.regex.Pattern

//
// Created by Fathur Radhy
// on July 2019-07-08.
//
class RiselokaEmailValidator {
    private val pattern: Pattern
    private var matcher: Matcher? = null

    init {
        pattern = Pattern.compile(EMAIL_PATTERN)
    }

    fun validate(hex: String): Boolean {

        matcher = pattern.matcher(hex)
        return matcher!!.matches()

    }

    companion object {
        private var sInstance: RiselokaEmailValidator? = null


        val instance: RiselokaEmailValidator
            get() {
                if (sInstance == null) {
                    sInstance = RiselokaEmailValidator()
                }
                return sInstance!!
            }
        private val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    }
}