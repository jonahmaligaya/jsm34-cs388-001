package com.example.BitFitPart2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class WaterDetailActivity : AppCompatActivity() {
    private lateinit var waterAmountInput: EditText
    private lateinit var waterNotesInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_water_detail_activity)

        // TODO: Find the views for the screen
        waterAmountInput= findViewById(R.id.enter_water_amount)
        waterNotesInput= findViewById(R.id.enter_water_notes)

        findViewById<Button>(R.id.add_water_button_detail).setOnClickListener{
            val newWaterEntity = WaterEntity(
                waterAmountInput.text.toString(),
                waterNotesInput.text.toString(),
            )

            lifecycleScope.launch(IO) {
                (application as BitFitApp).db.waterDao().insert(newWaterEntity)
            }


            waterAmountInput.getText().clear()
            waterNotesInput.getText().clear()
        }


    }
}