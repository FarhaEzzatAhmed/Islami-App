package com.example.islamii.main_activity.main_frament

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamii.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        //lama ydos ala item ywadih ll fragment bta3athaa
        bottomNavigationView.setOnItemSelectedListener {
            //it de 3ayda 3ala al menue item
            //quran dh ali ana msmyah feh al menu
            if(it.itemId == R.id.quran){
                pushFragment(QuranFragment())

            }else if(it.itemId == R.id.quran2){
                pushFragment(VersesFragment())

            }else if(it.itemId == R.id.sebha){
                pushFragment(TasbehFragment())
            }
            else if(it.itemId == R.id.radio){
                pushFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
        // 3lshan lama yfth ykon al selected quran w lazm tthat hna 3lshan lw hateha fo2 haytla3lii nafs al moshkla
        bottomNavigationView.selectedItemId = R.id.quran
    }

    fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment,fragment)
            .commit()
    }
}