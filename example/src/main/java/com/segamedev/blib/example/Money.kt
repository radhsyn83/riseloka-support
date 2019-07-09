package com.segamedev.blib.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.segamedev.bandros.BMoney
import kotlinx.android.synthetic.main.activity_money.*

class Money : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)

        bt_one.setOnClickListener {
            if (et_input.text.isNotEmpty()) {
                tv_output.text = BMoney.normal(et_input.text.toString())
            } else {
                tv_output.text = BMoney.normal("0")
            }
        }

        bt_two.setOnClickListener {
            if (et_input.text.isNotEmpty()) {
                tv_output.text = BMoney.toRupiah(et_input.text.toString())
            } else {
                tv_output.text = BMoney.toRupiah("0")
            }
        }

        bt_three.setOnClickListener {
            if (et_input.text.isNotEmpty()) {
                tv_output.text = BMoney.toRupiahRibuan(et_input.text.toString())
            } else {
                tv_output.text = BMoney.toRupiahRibuan("0")
            }
        }
    }
}
