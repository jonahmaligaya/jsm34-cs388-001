package com.example.BitFitPart2

import android.app.Application

class BitFitApp : Application() {
    val db by lazy { AppDataBase.getInstance(this) }
}