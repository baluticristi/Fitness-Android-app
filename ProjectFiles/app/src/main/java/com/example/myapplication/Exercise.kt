package com.example.myapplication

var exerciselist = mutableListOf<Exercise>()

class Exercise (
        var title: String,
        var routine: String,
        val id: Int? = exerciselist.size

){

}