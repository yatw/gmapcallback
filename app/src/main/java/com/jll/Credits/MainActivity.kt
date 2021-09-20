package com.jll.Credits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val adapter = ExploreViewPagerAdapter(this)
        viewPager2.adapter = adapter
    }

    inner class ExploreViewPagerAdapter(fp: FragmentActivity) : FragmentStateAdapter(fp){

        override fun getItemCount(): Int {
            return 1
        }

        override fun createFragment(slideIndex: Int): Fragment {
            return MapFragment()
        }
    }
}