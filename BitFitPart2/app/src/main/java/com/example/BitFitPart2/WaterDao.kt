package com.example.BitFitPart2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface WaterDao {
    @Query("SELECT * FROM water_table")
    fun getAll(): Flow<List<WaterEntity>>

    @Insert
    fun insertAll(waters: List<WaterEntity>)

    @Insert
    fun insert(water: WaterEntity)

    @Query("SELECT sum(waterAmount) FROM water_table")
    fun totalWaterAmount() : String



    @Query("DELETE FROM water_table")
    fun deleteAll()
}