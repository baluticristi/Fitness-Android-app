package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.main.HistoryWorkout
import com.example.myapplication.ui.main.historylist
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
   // private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
///Navigation View

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController=navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        setupWithNavController(bottomNavigationView, navController)
        bottomNavigationView.setOnClickListener {
            populateHistory()

        }
       // textView = findViewById(R.id.exercise)
        var sharedPreferences = getSharedPreferences("Count" , Context.MODE_PRIVATE)
        counter=sharedPreferences.getInt("c",0)

        populateRoutines()
        populateExercises()
        populateHistory()

        //Display list of routines
        //Cards pentru fiecare rutina VVVVVVVV

        //Launch a routine vvvvv

        //Routine is kept in Overview VVVVVVV

        //Aici se pot completa kg, repetarile per exercitiu VVVVVVV

        //cards pentru fiecare exercitiu VVVV

    //History --  Cards cu ultimele Date + Rutina facuta in data x + Volum total exercitii vvvv
        //Fiecare card Deschide o pagina cu detalii despre exercitiile din ziua data   vvvv
        //TODO  Nu se mai salveaza greutatile si seturile, vv
        //o scurta descriere pe tab 4 bvvvvvv
        //autorefresh la history  vvvvvv




    //ADD --creare o noua rutina ce trebuie ulterior afisata in home si pastrata in memorie

        //Check if username set
        //Daca nu e prompt la inceput pentru setarea lui.
        //Iconita de setari pe home de unde se poate schimba username-ul





    }

    fun populateHistory() {
            historylist.clear()
            for (i in (counter-1) downTo 0){
                var sharedPreferences = getSharedPreferences("Names" , Context.MODE_PRIVATE)
                val workoutFile = sharedPreferences.getString("workout"+i.toString(),null)

                sharedPreferences = getSharedPreferences( workoutFile, Context.MODE_PRIVATE)
                val routineName = sharedPreferences.getString("routine", null)
                val c = sharedPreferences.getInt("howmany",0)
                val dataex = makeReadable(workoutFile)
                for (j in 0..(c-1)){
                    val exercise =sharedPreferences.getString("exercise"+j.toString(),null)
                    val set1w = sharedPreferences.getString("set1w"+j.toString(), null)
                    val set1r = sharedPreferences.getString("set1r"+j.toString(), null)
                    val set2w = sharedPreferences.getString("set2w"+j.toString(), null)
                    val set2r = sharedPreferences.getString("set2r"+j.toString(), null)
                    val set3w = sharedPreferences.getString("set3w"+j.toString(), null)
                    val set3r = sharedPreferences.getString("set3r"+j.toString(), null)
                    val set4w = sharedPreferences.getString("set4w"+j.toString(), null)
                    val set4r = sharedPreferences.getString("set4r"+j.toString(), null)
                    val hist = HistoryWorkout(
                        routineName.toString(),
                        exercise.toString(),
                        dataex.toString(),
                        set1w.toString(),
                        set1r.toString(),
                        set2w.toString(),
                        set2r.toString(),
                        set3w.toString(),
                        set3r.toString(),
                        set4w.toString(),
                        set4r.toString()
                    )
                    historylist.add(hist)
                }


            }


    }
    private fun makeReadable(workoutFile: String?):String {
        val wk=workoutFile.toString()
        val list = wk.split(".")
        val y=list[0]
        val m = list [1]
        val d = list[2]
        val h = list[3]
        val mn = list[4]

        val res= "Data: "+d+"."+m+"."+y+"  "+h+":"+mn
        return res
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
            "Flotari paralele",
            "Umeri & Triceps"
        )
        exerciselist.add(exercise8)
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
}
