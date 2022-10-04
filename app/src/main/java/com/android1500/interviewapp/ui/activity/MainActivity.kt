package com.android1500.interviewapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.android1500.interviewapp.R
import com.android1500.interviewapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }

    private val navController by lazy {
        navHostFragment.navController
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupAppbarConfiguration()
        setupFloatActionButton()
    }

    private fun setupFloatActionButton(){
        binding.permissionAccessibility.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            navController.navigate(R.id.action_mainFragment_to_aboutFragment)
        }

    }

    private fun setupAppbarConfiguration(){
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.collapsingToolbar.setupWithNavController(binding.toolbar,navController, appBarConfiguration)
        navController.addOnDestinationChangedListener {  _, destination, _ ->
            if (destination.id == R.id.aboutFragment){
                binding.toolbar.menu.findItem(R.id.menu_about).isVisible =  false
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_about -> {
                navController.navigate(R.id.action_mainFragment_to_aboutFragment)
            }
            else -> super.onOptionsItemSelected(item) || item.onNavDestinationSelected(navController)
        }
       return true
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }





}