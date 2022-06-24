package com.example.myapplication

import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ExerciseCardBinding
import com.example.myapplication.ui.main.RunningExercises
import com.example.myapplication.ui.main.ViewClickListener

class ExerciseViewHolder (
    private val cardCellBinding: ExerciseCardBinding,
    private val clickListener: ViewClickListener
        ) : RecyclerView.ViewHolder(cardCellBinding.root){
            fun bindExercise(exercise: Exercise, sets:RunningExercises)
            {
                cardCellBinding.exercisename.text=exercise.title
                cardCellBinding.set1reps.setText(sets.set1r)
                cardCellBinding.set1weight.setText(sets.set1w)
                cardCellBinding.set2reps.setText(sets.set2r)
                cardCellBinding.set2weight.setText(sets.set2w)
                cardCellBinding.set3reps.setText(sets.set3r)
                cardCellBinding.set3weight.setText(sets.set3w)
                cardCellBinding.set4reps.setText(sets.set4r)
                cardCellBinding.set4weight.setText(sets.set4w)

                cardCellBinding.routineCard.setOnClickListener() {
                    clickListener.onClick(cardCellBinding, exercise.title)
                }

            }

}