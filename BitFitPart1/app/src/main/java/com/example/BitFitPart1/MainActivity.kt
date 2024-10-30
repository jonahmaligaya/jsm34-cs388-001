package com.example.BitFitPart1

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.BitFitPart1.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val waterAverage:TextView = findViewById(R.id.average_water_text_view)
        val date:TextView = findViewById(R.id.date_text_view)
        val addWaterButton:Button = findViewById(R.id.add_water_button)

        val listData = ArrayList<Model>()
        val db = DBHelper(this, null)
        val rView = findViewById<RecyclerView>(R.id.recyclerView)
        rView.layoutManager = LinearLayoutManager(this)




        val currentLDT = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        date.text = "\t\t\tDate: " + currentLDT.format(formatter)


        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        Log.i("DATESTUFF", dayOfYear.toString())


        val cursor = db.getWater()
        var averageWater = 0
        var entryCount = 0;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                listData.add(
                    Model(
                        cursor.getInt(cursor.getColumnIndex("water_amount")),
                        cursor.getString(cursor.getColumnIndex("notes"))
                    )
                )



                if (cursor.getInt(cursor.getColumnIndex("day_of_the_year")) == dayOfYear){
                    averageWater += cursor.getInt(cursor.getColumnIndex("water_amount"))
                    entryCount ++
                }


                val adapter = RVAdapter(listData)
                rView.adapter = adapter
            }
            if(entryCount > 0) waterAverage.text = "Average Water Intake: " + (averageWater/entryCount) + " oz"

        }

        addWaterButton.setOnClickListener{
            val intent = Intent(this, UserInputActivity::class.java)
            startActivity(intent)
        }

    }

}
