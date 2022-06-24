package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentAboutAppBinding
import com.example.myapplication.databinding.FragmentWorkoutOverviewBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddANewWorkout : Fragment() {


    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAboutAppBinding

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
        binding=FragmentAboutAppBinding.inflate(layoutInflater)
        val btn = binding.resetbutton
        btn.setOnClickListener(){
            var sharedPreferences = activity?.getSharedPreferences("Names" , Context.MODE_PRIVATE)
            sharedPreferences?.edit()?.clear()?.commit()
            sharedPreferences = activity?.getSharedPreferences("Count" , Context.MODE_PRIVATE)
            sharedPreferences?.edit()?.clear()?.commit()
            Toast.makeText(context,"Memorie resetata",Toast.LENGTH_LONG).show()

        }
       return binding.root
    // return inflater.inflate(R.layout.fragment_about_app, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            AddANewWorkout().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}