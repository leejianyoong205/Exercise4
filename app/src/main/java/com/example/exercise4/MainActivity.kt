package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateSaving()
        resetB.setOnClickListener {
            resultAge.text = ""
            resultSaving.text = ""
        }
    }

    fun calculateSaving(){
        var cal = Calendar.getInstance()
        val today = Calendar.getInstance()

        val datePicker = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

                cal.set(year, month, day)
                val dateFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(dateFormat, Locale.UK)
                val age = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR)

                resultAge.setText(age.toString())

                var sav: Int
                if (age in 16..20)
                    sav = 5000
                else if (age in 21..25)
                    sav = 14000
                else if (age in 26..30)
                    sav = 29000
                else if (age in 31..35)
                    sav = 50000
                else if (age in 36..40)
                    sav = 78000
                else if (age in 41..45)
                    sav = 116000
                else if (age in 46..50)
                    sav = 165000
                else if (age in 51..55)
                    sav = 228000
                else
                    sav = 0

                resultSaving.setText(sav.toString())

            }
        }


        dateB.setOnClickListener {

            val datePickerDialog = DatePickerDialog(
                this,
                datePicker,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

}



