package com.segamedev.blib.example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.segamedev.bandros.BSnackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_form.setOnClickListener {
            val intent = Intent(this, Form::class.java)
            startActivity(intent)
        }

        bt_money.setOnClickListener {
            val intent = Intent(this, Money::class.java)
            startActivity(intent)
        }

        bt_date.setOnClickListener {
            val intent = Intent(this, Date::class.java)
            startActivity(intent)
        }

        bt_snackbar.setOnClickListener {
            val intent = Intent(this, SnackBar::class.java)
            startActivity(intent)
        }
    }
}
