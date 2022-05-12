package com.androidstudy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.androidstudy.ui.login.LoginFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myNavHostFragment: NavHostFragment = supportFragmentManager.fragments[0] as NavHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        myNavHostFragment.navController.graph = graph
    }


}