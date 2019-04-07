package com.codingblocks.maps

import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity() {

    lateinit var map: GoogleMap

    lateinit var lastKnownLatLng: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {

            //Start requesting the location updates

            map = it

            val markerOptionsDelhi = MarkerOptions()
                .position(LatLng(28.73, 77.12))
                .draggable(true)
                .title("Marker in Delhi")

            val cameraUpdate = CameraUpdateFactory
                .newLatLngZoom(LatLng(28.73, 77.12), 15F)

            it.addMarker(markerOptionsDelhi)
            it.animateCamera(cameraUpdate)

            lastKnownLatLng = markerOptionsDelhi.position

            map.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {

                override fun onMarkerDragEnd(p0: Marker) {
                    map.addPolyline(PolylineOptions().add(lastKnownLatLng, p0.position))
                    lastKnownLatLng = p0.position
                }

                override fun onMarkerDragStart(p0: Marker?) {

                }

                override fun onMarkerDrag(p0: Marker?) {

                }

            })

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

}
