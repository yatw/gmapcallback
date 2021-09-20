package com.jll.Credits

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng


class MainActivity2 : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

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
}