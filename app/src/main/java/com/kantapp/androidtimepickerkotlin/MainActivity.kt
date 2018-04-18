package com.kantapp.androidtimepickerkotlin

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {

    var timepicker: TimePicker? = null
    var status: String? = null
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timepicker = findViewById(R.id.timePicker)
        val changeBtn = findViewById<Button>(R.id.btn_change_time)
        val changeDateTxt = findViewById<TextView>(R.id.txtpickTime)



        changeDateTxt.setText(currentTime())

        changeBtn.setOnClickListener {
            changeDateTxt.setText(currentTime())
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun currentTime(): String
    {
        timepicker!!.setIs24HourView(false)
        val hour = timepicker!!.hour
        val minute = timepicker!!.minute

        if (hour > 12)
        {
            status = "PM"
            return "Time : ${hour - 12}:$minute $status"
        } else {
            status = "AM"
            return "Time : $($hour-12):$minute $status"
        }

    }

}
