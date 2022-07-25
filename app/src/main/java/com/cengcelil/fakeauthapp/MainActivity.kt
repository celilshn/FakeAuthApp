package com.cengcelil.fakeauthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.cengcelil.fakeauthapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { b = it }.root)
        b.bottomNavigationView.setOnItemSelectedListener { item ->
            findNavController(R.id.nav_host_fragment).navigate(
                when (item.itemId) {
                    R.id.account -> R.id.accountFragment
                    R.id.account_splitted -> R.id.account_splitted_first
                    R.id.card -> R.id.card_fragment
                    else -> R.id.account_splitted_first
                }
            )
            true
        }
    }


}