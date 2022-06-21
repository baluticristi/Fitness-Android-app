package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.myapplication.Routine as Routine


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
///Navigation View

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController=navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        setupWithNavController(bottomNavigationView, navController)

    //Display list of routines
        //Cards pentru fiecare rutina



        //Launch a routine
        //Routine is kept in Overview
        //Aici se pot completa kg, repetarile per exercitiu
        //cards pentru fiecare exercitiu
    //History --  Cards cu ultimele Date + Rutina facuta in data x + Volum total exercitii
        //Fiecare card Deschide o pagina cu detalii despre exercitiile din ziua data
    //ADD --creare o noua rutina ce trebuie ulterior afisata in home si pastrata in memorie

        //Check if username set
        //Daca nu e prompt la inceput pentru setarea lui.
        //Iconita de setari pe home de unde se poate schimba username-ul





    }
    //        "Impins cu gantera din orizontala" +
//                "Impins cu gantera din inclinat" +
//                "Impins cu gantera din declinat" +
//                "Fluturari cu gantera orizontale" +
//                "Fluturari la cablu" +
//                "Flexii cu gantera" +
//                "Flexii ciocan" +
}
