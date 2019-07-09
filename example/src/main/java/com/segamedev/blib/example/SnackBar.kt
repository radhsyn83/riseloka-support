package com.segamedev.blib.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.segamedev.bandros.BSnackbar
import kotlinx.android.synthetic.main.activity_snack_bar.*

class SnackBar : AppCompatActivity() {
    
    private lateinit var bSnackbar: BSnackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
        
        bSnackbar = BSnackbar(this)
        
        bt_primary.setOnClickListener { 
            bSnackbar.primary("Hallo!! this is Primary snackbar.")
        }
        
        bt_success.setOnClickListener { 
            bSnackbar.success("Hallo!! this is Success snackbar.")
        }
        
        bt_info.setOnClickListener { 
            bSnackbar.info("Hallo!! this is Info snackbar.")
        }
        
        bt_warning.setOnClickListener {
            bSnackbar.warning("Hallo!! this is Warninng snackbar")
        }
        
        bt_danger.setOnClickListener {
            bSnackbar.danger("Hallo!! this is Danger snackbar")
        }
        
        bt_custom.setOnClickListener {
            bSnackbar.custom("Hallo!! this is Custom snackbar",
                icon = R.drawable.ic_bsnackbar_boy,
                bgColor = android.R.color.white,
                textColor = android.R.color.black)
        }
    }
}
