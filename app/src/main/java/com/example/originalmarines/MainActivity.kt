package com.example.originalmarines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.originalmarines.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            addFragment(fragment)
        }
    }

    //Add Fragment
    private fun addFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.frameMain, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}