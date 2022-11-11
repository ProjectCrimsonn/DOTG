package com.example.dotg

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class landing : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "NEWS"
                }
                1 -> {
                    "EVENTS"
                }
                2 -> {
                    "PLANNED"
                }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }
            }

        }.attach()
    }
}