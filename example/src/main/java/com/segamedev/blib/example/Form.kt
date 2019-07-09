package com.segamedev.blib.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.segamedev.bandros.BFormControl
import com.segamedev.bandros.BFormModel
import kotlinx.android.synthetic.main.activity_form.*

class Form : AppCompatActivity() {

    private lateinit var bFormControl: BFormControl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        bFormControl = BFormControl()
        val fName = BFormModel(et_name, "Name", 3, 6)
        val fEmail = BFormModel(et_email, "Email", type = BFormControl.TYPE_EMAIL)
        val fPassword = BFormModel(et_password, "Password", editTextConf = et_password_conf)
        bFormControl.init(this)
                .addForm(fName)
                .addForm(fEmail)
                .addForm(fPassword)
                .listener(object : BFormControl.OnFormControlListener {
                    override fun onSuccess() {
                        Toast.makeText(this@Form, "Register Sukses!",
                                Toast.LENGTH_LONG).show()
                    }

                    override fun onFailed(errorModel: BFormModel, msg: String) {
                        Toast.makeText(this@Form, msg,
                                Toast.LENGTH_LONG).show()
                    }
                })

        bt_register.setOnClickListener {
            bFormControl.check()
        }

    }
}
