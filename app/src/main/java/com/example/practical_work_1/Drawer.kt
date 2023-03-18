package com.example.practical_work_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practical_work_1.databinding.ActivityDrawerBinding

class Drawer : AppCompatActivity() {
    private lateinit var conf:AppBarConfiguration
    private lateinit var navContr:NavController
    private lateinit var binding:ActivityDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.itb.toolbar)

        navContr = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(
                R.id.item_menu_1,
                R.id.item_menu_2,
                R.id.item_menu_3),
            binding.drawer
        )
        setupActionBarWithNavController(navContr, conf)
        binding.navView.setupWithNavController(navContr)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navContr.navigateUp(conf) || super.onSupportNavigateUp()
    }
}