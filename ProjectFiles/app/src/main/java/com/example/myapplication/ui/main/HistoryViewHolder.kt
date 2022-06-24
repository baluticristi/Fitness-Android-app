package com.example.myapplication.ui.main

import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ExerciseCardBinding
import com.example.myapplication.databinding.PastCardBinding
import com.example.myapplication.ui.main.RunningExercises
import com.example.myapplication.ui.main.ViewClickListener

class HistoryViewHolder (
    private val cardCellBinding: PastCardBinding) : RecyclerView.ViewHolder(cardCellBinding.root){

    fun bindHistory(history:HistoryWorkout)
        {
            cardCellBinding.exercisename.text=history.exercise
            cardCellBinding.routinename.text=history.routine
            cardCellBinding.dataexercise.text=history.dataEx
            cardCellBinding.set1reps.text=history.set1r
            cardCellBinding.set1weight.text=history.set1w
            cardCellBinding.set2reps.text=history.set2r
            cardCellBinding.set2weight.text=history.set2w
            cardCellBinding.set3reps.text=history.set3r
            cardCellBinding.set3weight.text=history.set3w
            cardCellBinding.set4reps.text=history.set4r
            cardCellBinding.set4weight.text=history.set4w

        }

}