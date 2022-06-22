package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


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
        //Cards pentru fiecare rutina VVVVVVVV
        populateRoutines()



        //Launch a routine


        //Routine is kept in Overview VVVVVVV

        //Aici se pot completa kg, repetarile per exercitiu VVVVVVV

        //cards pentru fiecare exercitiu VVVV
        populateExercises()
    //History --  Cards cu ultimele Date + Rutina facuta in data x + Volum total exercitii
        //Fiecare card Deschide o pagina cu detalii despre exercitiile din ziua data
    //ADD --creare o noua rutina ce trebuie ulterior afisata in home si pastrata in memorie

        //Check if username set
        //Daca nu e prompt la inceput pentru setarea lui.
        //Iconita de setari pe home de unde se poate schimba username-ul





    }

    private fun populateExercises() {
        val exercise1 = Exercise(
            "Impins cu gantera din orizontala",
            "Piept & Biceps"
        )
        exerciselist.add(exercise1)
        val exercise2 = Exercise(
            "Fluturari cu gantera orizontale",
            "Piept & Biceps"
        )
        exerciselist.add(exercise2)
        val exercise3 = Exercise(
            "Flexii cu gantera",
            "Piept & Biceps"
        )
        exerciselist.add(exercise3)
        val exercise4 = Exercise(
            "Flexii ciocan",
            "Piept & Biceps"
        )
        exerciselist.add(exercise4)
        val exercise5 = Exercise(
            "Ramat la Smith Machine",
            "Spate"
        )
        exerciselist.add(exercise5)
        val exercise6 = Exercise(
            "Squats",
            "Picioare"
        )
        exerciselist.add(exercise6)
        val exercise7 = Exercise(
            "Military Shoulder Press",
            "Umeri & Triceps"
        )
        exerciselist.add(exercise7)
        val exercise8 = Exercise(
            "Impins cu gantera din orizontala",
            "Umeri & Triceps"
        )
        exerciselist.add(exercise8)
    }

//        "Impins cu gantera din orizontala" +
//                "Impins cu gantera din inclinat" +
//                "Impins cu gantera din declinat" +
//                "Fluturari cu gantera orizontale" +
//                "Fluturari la cablu" +
//                "Flexii cu gantera" +
//                "Flexii ciocan" +


}
private fun populateRoutines() {
    val routine1 = Routine(
        "Piept & Biceps"
    )
    routinelist.add(routine1)

    val routine2 = Routine(
        "Picioare"
    )
    routinelist.add(routine2)
    val routine3 = Routine(
        "Umeri & Triceps"
    )
    routinelist.add(routine3)
    val routine4 = Routine(
        "Spate"
    )
    routinelist.add(routine4)
}