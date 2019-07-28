package com.segamedev.bandros

import android.widget.EditText

//
// Created by Fathur Radhy
// on July 2019-07-08.
//

/**
 * Shows a title, or header, at the top of the dialog.
 *
 * @param formName will be show on error message
 * @param type BFormControl.TYPE_NORMAL or BFormControl.TYPE_EMAIL
 * @param editTextConf for Verification. Ex: Password and Password Confirmation
 */
data class BFormModel(
    var editText: EditText,
    var formName: String,
    var formMinLength: Int? = null,
    var formMaxLength: Int? = null,
    var type: Int? = null,
    var editTextConf: EditText? = null
)