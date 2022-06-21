package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RoutineCardBinding

class RoutineAdapter (private val routines: List<Routine>):
    RecyclerView.Adapter<RoutineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = RoutineCardBinding.inflate(from,parent,false)
        return RoutineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        holder.bindRoutine(routines[position])
    }

    override fun getItemCount(): Int = routines.size

}