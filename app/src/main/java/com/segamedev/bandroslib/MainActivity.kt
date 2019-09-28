package com.segamedev.bandroslib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formInput.onLeftButtonClick {
            Toast.makeText(this, "Left clicked", Toast.LENGTH_LONG).show()
        }

        formInput.onRightButtonClick {
            Toast.makeText(this, "Right clicked", Toast.LENGTH_LONG).show()
        }

    }
}
