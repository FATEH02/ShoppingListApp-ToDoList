package com.example.myshoppinglistapp

//package com.example.locationapp

import android.content.Context
import androidx.core.content.ContextCompat
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.PackageManagerCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import java.util.Locale
//import com.google.android.gms:play-services-maps

class LocationUtils(val context:Context) {


    private val _fusedLocationClient:FusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(context)//interacting with google play services to access the laction of the device
    @SuppressLint("MissingPermission")
//call backing the service to resposend
    fun requestLocationUpdates(viewModel: LocationViewModel)
    {
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                locationResult.lastLocation?.let{
                    val location = LocationData(latitude = it.latitude, longitude = it.longitude)
                    viewModel.updateLocation(location)
                }
            }
        }
        val locationResult = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,1000).build()

        _fusedLocationClient.requestLocationUpdates(locationResult,locationCallback, Looper.getMainLooper())
    }


    //this function will check wether permission is granted or not
    fun hasLocationPermission(context: Context): Boolean {
        //so here:we are checking whether app is granted permission or not this functino will give us a value that we will compare a constant with pacakagemanager.permission_granted

        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION //fine location permission
        ) == PackageManager.PERMISSION_GRANTED

                &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION //fine location permission
                ) == PackageManager.PERMISSION_GRANTED


    }
//    fun reverseGeocodeLocation(location:LocationData):String{
//        val geocoder = Geocoder(context, Locale.getDefault())
//        val cordinates = LatLng(location.latitude,location.longitude)
//        val addresses:MutableList<Address>? = geocoder.getFromLocation(cordinates.latitude,cordinates.longitude,1)
//        return  if(addresses?.isNotEmpty()==true)
//        {
//            addresses[0].getAddressLine(0)
//        }else
//        {
//            "Address not found"
//        }
//    }
}
