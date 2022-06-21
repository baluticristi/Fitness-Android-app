package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RoutineCardBinding


class RoutineViewHolder (
    private val cardCellBinding: RoutineCardBinding
        ):RecyclerView.ViewHolder(cardCellBinding.root){

            fun bindRoutine(routine: Routine){
                cardCellBinding.routinetitle.text=routine.title
            }
}