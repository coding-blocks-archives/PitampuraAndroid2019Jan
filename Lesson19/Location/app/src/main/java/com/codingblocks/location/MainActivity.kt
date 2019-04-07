package com.codingblocks.location

import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LocationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

//        //This gives the last cached location of the user in the device
//        val lastKnownLocation =
//            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)


//        //Specify the criteria for using a provider
//        val criteria = Criteria().apply {
//            isSpeedRequired = true
//            isAltitudeRequired = true
//            powerRequirement = Criteria.POWER_LOW
//        }
//        //Attempt to get a provider with the above mentioned criteria
//        locationManager.getBestProvider(criteria,false)

        //Adds a proximity listener to the specified lat and long with the specified radius.
//        locationManager.addProximityAlert(lat,long,20,-1,pi)

        btnStartLocation.setOnClickListener {
            //Request the permissions from the user

            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                //Show an alert dialog here
                AlertDialog.Builder(this)
                    .setTitle("Location Disabled")
                    .setMessage("Please enable the location for the app to work properly!")
                    .setPositiveButton("Ok") { _, _ ->
                        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                        //Start an intent to the settings page for location
                    }
                    .setNegativeButton("Cancel") { _, _ ->
                        finish()
                    }
                    .show()

            } else {
                //Start the location request
                //This will provide the user with continuous location updates as long as both
                //the conditions (minTime and minDistance) are met *and* the app is in foreground
                //or there is a foreground service of the app running which requests this update

                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    1000L,
                    10F,
                    this
                )

//                //This gives a single location update
//                locationManager.requestSingleUpdate(
//                    LocationManager.GPS_PROVIDER,
//                    this,
//                    null
//                )
            }
        }
    }


    override fun onLocationChanged(location: Location?) {

        //get the lat and long from location
        //create a LatLng object val latlng = LatLng(latitude,longitude)
        //Create  a MarkerOptions object : val mo = MarkerOptions().position(latlng)
        //Add the marker to the map : map.addMarker(mo)

        location?.let {

            val loc = Location(LocationManager.GPS_PROVIDER).apply {
                latitude = 27.33
                longitude = 28.44
            }

            Log.e("TAG", "_______________")
            Log.e("TAG", "Provider : " + it.provider)
            Log.e("TAG", "Accuracy : " + it.accuracy)
            Log.e("TAG", "Altitude : " + it.altitude)
            Log.e("TAG", "Latitude : " + it.latitude)
            Log.e("TAG", "Longitude : " + it.longitude)
            Log.e("TAG", "Time : " + it.time)
            Log.e("TAG", "Speed : " + it.speed)
            Log.e("TAG", "Distance to a location : " + it.distanceTo(loc))
            Log.e("TAG", "_______________")
        }

    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

    override fun onStop() {
        super.onStop()
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.removeUpdates(this)
    }

}
