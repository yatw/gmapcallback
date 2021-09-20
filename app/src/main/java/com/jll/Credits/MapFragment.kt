package com.jll.Credits

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapFragment: Fragment(), OnMapReadyCallback {

    override fun onMapReady(googleMap: GoogleMap) {
        Log.i("Log=>","onMapReady")

        val location = LatLng(33.8561871, -118.071644)
        val zoomlevel = 10f

        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(location, zoomlevel),
            800,
            object: GoogleMap.CancelableCallback{
                override fun onFinish() {
                    Log.i("Log=>","after finish animation, zoom lv is ${googleMap.cameraPosition.zoom}")
                }

                override fun onCancel() {
                    Log.i("Log=>","onCancel")
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }
}
