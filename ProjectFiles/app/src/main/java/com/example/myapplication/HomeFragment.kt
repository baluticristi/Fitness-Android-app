package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(layoutInflater)

        populateRoutines()

        binding.recyclerView.apply {
            //layoutManager = GridLayoutManager(this.context , 3)
            layoutManager = LinearLayoutManager(context)
            adapter = RoutineAdapter(routinelist)
        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
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
