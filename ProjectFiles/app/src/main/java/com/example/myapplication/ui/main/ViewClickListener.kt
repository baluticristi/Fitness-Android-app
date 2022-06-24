package com.example.myapplication.ui.main

import android.widget.EditText
import com.example.myapplication.databinding.ExerciseCardBinding

interface ViewClickListener {
    fun onClick(exerciseCardBinding: ExerciseCardBinding, name:String)
}