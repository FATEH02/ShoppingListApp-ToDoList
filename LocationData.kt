package com.example.myshoppinglistapp
//making a class that can store out of the api


data class LocationData(
    val latitude:Double,
    val longitude:Double
)

data class GeocodingResoponse(
    val result:List<GeocodingResult>,
    val status:String
)

data class GeocodingResult(
    val formatted_address:String
)

