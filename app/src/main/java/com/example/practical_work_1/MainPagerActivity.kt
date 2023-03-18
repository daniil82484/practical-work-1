package com.example.practical_work_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pager)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ImageViewPagerAdapter()
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout2)
        TabLayoutMediator(tabLayout,viewPager){tab, position ->


        }.attach()
    }
}