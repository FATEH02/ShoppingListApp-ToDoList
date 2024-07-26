package com.example.myshoppinglistapp

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable


fun LocationSelectionScreen(
    location:LocationData,
    onLocationSelected:(LocationData)->Unit
){
    //a verable that will hold lat long of user
    var userLocation = remember {
        mutableStateOf(LatLng(location.latitude,location.longitude))
    }


//camra posiiotn of google map
var comraPositionState = rememberCameraPositionState{
    position=CameraPosition.fromLatLngZoom(userLocation.value,10f)
}


Column(modifier = Modifier.fillMaxSize()) {
//a google map
    //
    GoogleMap(
        modifier = Modifier
            .weight(1f)
            .padding(top = 16.dp)
,
        cameraPositionState = comraPositionState,
        onMapClick = {
            userLocation.value=it
        }

    ){
Marker(state = MarkerState(position = userLocation.value))



    }


var newLocation:LocationData

//a button
        Button(onClick = {
            newLocation=LocationData(userLocation.value.latitude,userLocation.value.longitude)
            onLocationSelected(newLocation)
        }) {
        Text(text = "Set Location")
    }



}


}
