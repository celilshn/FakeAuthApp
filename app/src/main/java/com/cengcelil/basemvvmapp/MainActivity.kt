package com.cengcelil.basemvvmapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.cengcelil.basemvvmapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { b = it }.root)

        val map = HashMap<String, Int>()
        b.bottomNavigationView.setOnItemSelectedListener { item ->
            findNavController(R.id.nav_host_fragment).navigate(
                when (item.itemId) {
                    R.id.black -> R.id.blackFragment
                    R.id.white -> R.id.whiteFragment
                    else -> R.id.blackFragment
                }
            )
            true
        }
    }


}