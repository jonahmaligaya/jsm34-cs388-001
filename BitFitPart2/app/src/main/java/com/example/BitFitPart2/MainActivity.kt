package com.example.BitFitPart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val waterListFragment: Fragment = WaterListFragment()
        val analyticsFragment: Fragment = StatsFragment()


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        //Handle Activity Switching
        findViewById<Button>(R.id.add_water_button)?.setOnClickListener {
            val intent = Intent(this, WaterDetailActivity::class.java)
            startActivity(intent)
        }

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_home -> fragment = waterListFragment
                R.id.action_stats -> fragment = analyticsFragment

            }
            fragmentManager.beginTransaction().replace(R.id.water_frame_layout, fragment).commit()
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.action_home
    }
}