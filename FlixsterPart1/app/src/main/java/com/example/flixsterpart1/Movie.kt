package com.example.flixsterpart1

import com.google.gson.annotations.SerializedName

//Taken from BestSellerBooks

class Movie {

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("poster_path")
    var poster_path: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null



}