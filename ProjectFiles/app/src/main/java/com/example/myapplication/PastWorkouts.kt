package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentPastWorkoutsBinding
import com.example.myapplication.databinding.PastCardBinding
import com.example.myapplication.ui.main.HistoryAdapter
import com.example.myapplication.ui.main.HistoryWorkout
import com.example.myapplication.ui.main.historylist
import java.util.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PastWorkouts : Fragment() {

    private lateinit var binding: FragmentPastWorkoutsBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPastWorkoutsBinding.inflate(layoutInflater)
        populateHistory()
        binding.recyclerView.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = HistoryAdapter(historylist)
        }


        return binding.root

        // return inflater.inflate(R.layout.fragment_past_workouts, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            PastWorkouts().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun populateHistory() {
        historylist.clear()
        var sharedPreferences = activity?.getSharedPreferences("Count" , Context.MODE_PRIVATE)
        if (sharedPreferences != null) {
            counter=sharedPreferences.getInt("c",0)
        }

        for (i in (counter-1) downTo 0){
            var sharedPreferences = activity?.getSharedPreferences("Names" , Context.MODE_PRIVATE)
            val workoutFile = sharedPreferences?.getString("workout"+i.toString(),null)

            sharedPreferences = activity?.getSharedPreferences( workoutFile, Context.MODE_PRIVATE)
            val routineName = sharedPreferences?.getString("routine", null)
            val c = sharedPreferences?.getInt("howmany",0)
            val dataex = makeReadable(workoutFile)
            if (c != null) {
                for (j in 0..(c-1)){
                    val exercise =sharedPreferences?.getString("exercise"+j.toString(),null)
                    val set1w = sharedPreferences?.getString("set1w"+j.toString(), null)
                    val set1r = sharedPreferences?.getString("set1r"+j.toString(), null)
                    val set2w = sharedPreferences?.getString("set2w"+j.toString(), null)
                    val set2r = sharedPreferences?.getString("set2r"+j.toString(), null)
                    val set3w = sharedPreferences?.getString("set3w"+j.toString(), null)
                    val set3r = sharedPreferences?.getString("set3r"+j.toString(), null)
                    val set4w = sharedPreferences?.getString("set4w"+j.toString(), null)
                    val set4r = sharedPreferences?.getString("set4r"+j.toString(), null)
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


}