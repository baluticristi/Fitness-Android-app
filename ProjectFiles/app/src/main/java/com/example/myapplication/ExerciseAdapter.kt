package com.example.myapplication


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ExerciseCardBinding
import com.example.myapplication.ui.main.RunningExercises
import com.example.myapplication.ui.main.ViewClickListener

var routineexercises = mutableListOf<Exercise>()

class ExerciseAdapter (private val exercises: List<Exercise>,
                       val Rout: String?,
                       var listOfSets: MutableList<RunningExercises>,
                       private val clickListener: ViewClickListener

):
    RecyclerView.Adapter<ExerciseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ExerciseCardBinding.inflate(from,parent,false)
        return ExerciseViewHolder(binding, clickListener)
    }
    override fun getItemCount(): Int {
        routineexercises.clear()
        listOfSets.clear()
        var s = 0
        for (ex in exercises){
            if(ex.routine == Rout) {
                s++
                routineexercises.add(ex)
                val setNou: RunningExercises = RunningExercises(ex.title)
                listOfSets.add(setNou)
            }

        }
        return s
    }
    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bindExercise(routineexercises[position],listOfSets[position])
    }


}