package com.example.myshoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myshoppinglistapp.ui.theme.MyShoppingListAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyShoppingListAppTheme {
                Surface (  modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){

                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Navigation()
{
    val navController = rememberNavController()
    val viewModel:LocationViewModel= viewModel()
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)

    NavHost(
        navController = navController,
        startDestination = "shoppinglistscreen"
    ) {
        composable("shoppinglistscreen") {
            ShoppingListApp(
                locationUtils = locationUtils,
                viewModel = viewModel,
                navController = navController,
                context = context,
                address = viewModel.address.value.firstOrNull()?.formatted_address ?: "no adress"
            )
        }
    dialog("locationscreen")
    {
        backstack->
        viewModel.location.value?.let {
            it1->
            LocationSelectionScreen(location = it1, onLocationSelected = {
                viewModel.fetchAdress("${it.latitude},${it.longitude}")
                navController.popBackStack()
            })


        }
    }

    }

}
