package com.segamedev.bandros

import android.content.Context
import android.text.TextUtils
import android.util.Log

import java.util.ArrayList

//
// Created by Fathur Radhy
// on July 2019-07-08.
//
class BFormControl {

    private lateinit var context: Context
    private lateinit var formModel: ArrayList<BFormModel>
    private var listener: OnFormControlListener? = null

    interface OnFormControlListener {
        fun onSuccess()
        fun onFailed(errorModel: BFormModel, msg: String)
    }

    fun init(context: Context) : BFormControl {
        this.context = context
        formModel = arrayListOf()
        return this
    }

    fun addForm(form: BFormModel) : BFormControl {
        formModel.add(form)
        return this
    }

    fun listener(listener: OnFormControlListener): BFormControl {
        this.listener = listener
        return this
    }

    fun check(): BFormControl {
        var x = 0
        while (x < formModel.size) {
            val fm = formModel[x]

            if (fm.type != TYPE_EMAIL) {

                if (TextUtils.isEmpty(fm.editText.text)) {
                    Log.e(LOG_TAG, "${fm.formName} empty")
                    //Show error
                    listener!!.onFailed(
                        fm, String.format(context.resources
                                .getString(R.string.blib_form_is_empty),
                            fm.formName
                        )
                    )
                    return this
                }

                if (fm.formMinLength != null) {
                    if (fm.editText.length() < fm.formMinLength!!) {
                        Log.e(LOG_TAG, "${fm.formName} length max ${fm.formMinLength}")
                        //Show error
                        listener!!.onFailed(
                            fm,
                            String.format(
                                context.resources.getString(R.string.blib_form_min_length),
                                fm.formName, fm.formMinLength.toString()
                            )
                        )
                        return this
                    }
                }

                if (fm.formMaxLength != null) {
                    Log.e(LOG_TAG, "${fm.editText.length()} | ${fm.formMaxLength}")

                    if (fm.editText.length() > fm.formMaxLength!!) {
                        Log.e(LOG_TAG, "${fm.formName} length max ${fm.formMaxLength}")
                        //Show error
                        listener!!.onFailed(
                            fm,
                            String.format(
                                context.resources.getString(R.string.blib_form_max_length),
                                fm.formName, fm.formMaxLength.toString()
                            )
                        )
                        return this
                    }
                }

                if (fm.editTextConf != null) {
                    if (fm.editText.text.toString() != fm.editTextConf!!.text.toString()) {
                        Log.e(LOG_TAG, "${fm.formName} confirmation not match")
                        //Show error
                        listener!!.onFailed(
                            fm,
                            String.format(
                                context.resources.getString(R.string.blib_form_conf),
                                fm.formName
                            )
                        )
                        return this
                    }
                }

            } else {

                if (TextUtils.isEmpty(fm.editText.text)) {
                    Log.e(LOG_TAG, "${fm.formName} empty")
                    //Show error
                    listener!!.onFailed(
                            fm, String.format(context.resources
                            .getString(R.string.blib_form_is_empty),
                            fm.formName)
                    )
                    return this
                }

                if (!EmailValidator.instance.validate(fm.editText.text.toString().trim())) {
                    Log.e(LOG_TAG, "${fm.formName} not valid")
                    //Show error
                    listener!!.onFailed(
                            fm, String.format(
                            context.resources
                                    .getString(R.string.blib_form_email_invalid), fm.formName)
                    )
                    return this
                }

            }

            x += 1
        }

        listener!!.onSuccess()
        return this
    }

    companion object {
        const val TYPE_EMAIL = 1
        const val TYPE_NORMAL = 0

        private val LOG_TAG = BFormControl::class.java.simpleName
    }
}
