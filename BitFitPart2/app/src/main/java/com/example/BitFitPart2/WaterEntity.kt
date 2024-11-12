package com.example.BitFitPart2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_table")
data class WaterEntity (
    @ColumnInfo val waterAmount : String,
    @ColumnInfo val waterNotes : String,
    @PrimaryKey(autoGenerate = true) val id : Long =0,
)
