package com.example.myshoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel:ViewModel() {
    private  val _location = mutableStateOf<LocationData?>(null)
    val location:State<LocationData?> = _location

    private  val _address = mutableStateOf(listOf<GeocodingResult>())
    val address:State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation:LocationData)
    {
        _location.value=newLocation
    }

    fun fetchAdress(latlng:String){
        try{

            viewModelScope.launch {
                val   result = RetrofitClient.create().getAddressFromCoording(
                    latlng,
                    "AIzaSyAuzQRa0dh5b8awhtXsJKYXV1wRuhRaJCk"
                )
                _address.value=result.result

            }


        }catch (
            e:Exception
        ){
            Log.d("res1","${e.cause}${e.message}")
        }
    }
 }
