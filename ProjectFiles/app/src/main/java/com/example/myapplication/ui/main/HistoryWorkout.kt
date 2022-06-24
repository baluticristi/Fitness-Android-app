package com.example.myapplication.ui.main

var historylist = mutableListOf<HistoryWorkout>()

class HistoryWorkout (
        var routine: String,
        var exercise: String,
        var dataEx : String,
        var set1w: String,
        var set1r: String,
        var set2w: String,
        var set2r: String,
        var set3w: String,
        var set3r: String,
        var set4w: String,
        var set4r: String,

        val id: Int? = historylist.size
){

}