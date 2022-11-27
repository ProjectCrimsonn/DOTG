package com.example.dotg

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.dotg.databinding.ActivityLandingBinding
import com.example.dotg.databinding.FragmentEventsFragmentBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class landing : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLandingBinding.inflate(layoutInflater)
        val view = binding.root
        val userEmail = intent.getStringExtra("user_email")
        val uid = intent.getStringExtra("user_id")


        setContentView(view)


        setSupportActionBar(binding.appBarHome.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        appBarConfiguration = AppBarConfiguration(
            setOf(), drawerLayout
        )

        binding.appBarHome.toolbar.setNavigationIcon(R.drawable.menu_new)

        val header = navView.getHeaderView(0)
        val usernameview = header.findViewById<TextView>(R.id.user_email)
        usernameview.setText(userEmail)

        val useridview = header.findViewById<TextView>(R.id.username)
        useridview.setText("USER ID : " + uid)



        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "EVENTS"
                }
                1 -> {
                    "NEWS"
                }
                2 -> {
                    "NOTIFICATIONS"
                }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }
            }

        }.attach()


    }

}