package com.codingblocks.maps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivityLocation : AppCompatActivity(), LocationListener {

//    https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=New+Delhi&destinations=Gurgaon&key=AIzaSyD6LRMj68BDF-0jFge08brPRqj3-C2SiWM

    lateinit var map: GoogleMap
    private var lastKnownLatLng: LatLng? = null
    private var lastKnownMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {

            it.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style))

            //As soon as the map is loaded, start requesting location updates
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

            lm.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L,
                0F,
                this
            )

            //Start requesting the location updates

            map = it

//            map.setOnMapClickListener { latlng ->
//                val mo = MarkerOptions()
//                    .position(latlng)
//                    .draggable(true)
//                    .title("Marker in Delhi")
//
//                val cu = CameraUpdateFactory
//                    .newLatLngZoom(latlng, 15F)
//
//                map.addMarker(mo)
//                map.animateCamera(cu)
//            }

        }

    }

    override fun onLocationChanged(location: Location?) {
        location?.let {
            if (lastKnownLatLng == null) {
                lastKnownLatLng = LatLng(it.latitude, it.longitude)
            }

            val currentLatLng = LatLng(it.latitude, it.longitude)
            val currentMarkerOptions = MarkerOptions().position(currentLatLng)

            map.addPolyline(
                PolylineOptions().add(
                    lastKnownLatLng, currentLatLng
                )
            )

            lastKnownMarker?.remove()
            lastKnownMarker = map.addMarker(currentMarkerOptions)
            map.animateCamera(CameraUpdateFactory.newLatLng(currentLatLng))
            lastKnownLatLng = currentLatLng
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

}
