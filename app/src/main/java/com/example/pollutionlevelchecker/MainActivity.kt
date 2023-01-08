package com.example.pollutionlevelchecker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.pollutionlevelchecker.ui.MainScreen
import com.example.pollutionlevelchecker.ui.theme.PollutionLevelCheckerTheme
import com.example.pollutionlevelchecker.viewmodel.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PollutionLevelCheckerTheme {
                MainScreen()
            }
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)
        getCurrentLocation()
//        viewModel.getCurrentPollutionInfo()
    }

    private fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestLocationPermission()
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            viewModel.getCurrentLocationName(location.latitude, location.longitude)
        }
    }

//    private fun isLocationPermissionGranted(): Boolean {
//        return with(PackageManager.PERMISSION_GRANTED) {
//            return ActivityCompat.checkSelfPermission(
//                this@MainActivity,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == this || ActivityCompat.checkSelfPermission(
//                this@MainActivity,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) == this
//        }
//    }

//    private fun isLocationEnabled(): Boolean {
//        val locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//                || locationManager.isProviderEnabled(
//            LocationManager.NETWORK_PROVIDER
//        )
//    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this@MainActivity, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
            ), 44
        )
    }
}