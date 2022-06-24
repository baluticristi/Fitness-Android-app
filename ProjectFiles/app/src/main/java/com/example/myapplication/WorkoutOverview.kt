package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ExerciseCardBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentWorkoutOverviewBinding
import com.example.myapplication.ui.main.RunningExercises
import com.example.myapplication.ui.main.ViewClickListener
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var myRoutine: String?=null
public var counter : Int = 0

class WorkoutOverview : Fragment() , ViewClickListener{
    var listOfSets = mutableListOf<RunningExercises>()
    private lateinit var binding: FragmentWorkoutOverviewBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

    }
    override fun onClick(card:ExerciseCardBinding, name:String){
        for(ex in listOfSets){
//            Toast.makeText(context,"titlu ex:  "+ex.name+",\n titlu card ex"+ name,Toast.LENGTH_LONG).show()
            if(name==ex.name) {
                ex.set1w = card.set1weight.text.toString()
                ex.set1r = card.set1reps.text.toString()
                ex.set2w = card.set2weight.text.toString()
                ex.set2r = card.set2reps.text.toString()
                ex.set3w = card.set3weight.text.toString()
                ex.set3r = card.set3reps.text.toString()
                ex.set4w = card.set4weight.text.toString()
                ex.set4r = card.set4reps.text.toString()
            }

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentWorkoutOverviewBinding.inflate(layoutInflater)
        //Toast.makeText(context,"clicked on smth,"+ myRoutine+" created new instance",Toast.LENGTH_LONG).show()
        val mainActivity=this

        if(myRoutine!= null){

//            var text : TextView = view.findViewById(R.id.exercise)
//            text.text= myRoutine
            binding.recyclerView.apply {
                //layoutManager = GridLayoutManager(this.context , 3)
                layoutManager = LinearLayoutManager(context)
                adapter = ExerciseAdapter(exerciselist, myRoutine, listOfSets, mainActivity)
            }

            val title=binding.exercise
            title.text= myRoutine

            val btn = binding.button
            btn.setOnClickListener{
                //TODO SALVEAZA DATELE IN Mmorie vvvvvv
                val calendar= Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val minute = calendar.get(Calendar.MINUTE)

                val key : String = year.toString()+"."+month.toString()+"."+day.toString()+"."+hour.toString()+"."+minute.toString()

                saveWorkout(key)
                Toast.makeText(context,"Workout Salvat! ",Toast.LENGTH_LONG).show()
            }
            return binding.root
        }

//        val btn = activity.findViewById(R.id.button) as Button
        return inflater.inflate(R.layout.fragment_workout_overview, container, false)
    }


    companion object {

        fun setRout(r:String){
            myRoutine=r
        }

        fun newInstance(param1: String) =
            WorkoutOverview().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun saveWorkout(key : String){

        saveWorkoutList(key)

        val sharedPreferences = activity?.getSharedPreferences(key , Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        editor?.apply {
            putString("routine", myRoutine)
            var x=0
            for (ex in listOfSets)
            {
                putString("exercise"+x.toString(), ex.name)
                putString("set1w"+x.toString(), ex.set1w)
                putString("set1r"+x.toString(), ex.set1r)
                putString("set2w"+x.toString(), ex.set2w)
                putString("set2r"+x.toString(), ex.set2r)
                putString("set3w"+x.toString(), ex.set3w)
                putString("set3r"+x.toString(), ex.set3r)
                putString("set4w"+x.toString(), ex.set4w)
                putString("set4r"+x.toString(), ex.set4r)
                x++

            }
            putInt("howmany", x)
        }?.apply()
      //  Toast.makeText(context,"Data Saved!",Toast.LENGTH_LONG).show()
    }
    private fun saveWorkoutList ( key : String){
        var sharedPreferences = activity?.getSharedPreferences("Names" , Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.apply {

            putString("workout"+ counter.toString(), key)
            counter++
        }?.apply()

        sharedPreferences = activity?.getSharedPreferences("Count" , Context.MODE_PRIVATE)
        val edit = sharedPreferences?.edit()
        edit?.apply {

            putInt("c", counter)

        }?.apply()
    }

}

