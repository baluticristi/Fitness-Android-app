package com.example.myapplication.ui.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ExerciseCardBinding
import com.example.myapplication.databinding.PastCardBinding


class HistoryAdapter (private val history: List<HistoryWorkout>):
    RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = PastCardBinding.inflate(from,parent,false)
        return HistoryViewHolder(binding)
    }
    override fun getItemCount(): Int = history.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bindHistory(history[position])
    }


}