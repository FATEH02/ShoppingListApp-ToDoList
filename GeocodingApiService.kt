package com.example.myshoppinglistapp

import com.google.android.gms.common.api.internal.ApiKey
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {
    @GET("maps/api/geocode/jason")
    suspend fun  getAddressFromCoording(
        @Query("latlng") latlng:String,
        @Query("key") apiKey: String
    ):GeocodingResoponse

}
