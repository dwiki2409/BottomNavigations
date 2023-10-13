package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.Home
import com.example.myapplication.databinding.ActivityMainBinding

/**
* The main activity of the application.
*/
class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
binding = ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)
replaceFragment(Home())

binding.bottomNavigationView.setOnItemSelectedListener {

when (it.itemId) {

R.id.home -> replaceFragment(Home())
R.id.profile -> replaceFragment(Profile())
R.id.settings -> replaceFragment(Settings())

else -> {
// Handle other menu items if needed.
}

}

true
}
}

/**
* Replaces the current fragment in the activity's layout with the specified fragment.
*
* @param fragment The fragment to be displayed.
*/
private fun replaceFragment(fragment: Fragment) {
val fragmentManager = supportFragmentManager
val fragmentTransaction = fragmentManager.beginTransaction()
fragmentTransaction.replace(R.id.frame_layout, fragment)
fragmentTransaction.commit()
}
}
