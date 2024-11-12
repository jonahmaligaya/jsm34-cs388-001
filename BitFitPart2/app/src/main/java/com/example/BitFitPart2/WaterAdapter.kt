package com.example.BitFitPart2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WaterAdapter(
    private val context: Context,
    private val water: MutableList<WaterEntity>) : RecyclerView.Adapter<WaterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.water_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val waterEntity = water[position]
        holder.bind(waterEntity)
    }

    override fun getItemCount() : Int{
        return water.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val waterAmountView = itemView.findViewById<TextView>(R.id.water_amount)
        private val waterNotesView = itemView.findViewById<TextView>(R.id.water_notes)

        fun bind(waterItem: WaterEntity) {
            waterAmountView.text = waterItem.waterAmount + " oz"
            waterNotesView.text = waterItem.waterNotes
        }
    }
}