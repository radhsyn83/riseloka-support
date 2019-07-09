package com.segamedev.bandros

import android.widget.EditText

//
// Created by Fathur Radhy
// on July 2019-07-08.
//
data class BFormModel(
    var editText: EditText,
    var formName: String,
    var formMinLength: Int? = null,
    var formMaxLength: Int? = null,
    var type: Int? = null,
    var editTextConf: EditText? = null
)