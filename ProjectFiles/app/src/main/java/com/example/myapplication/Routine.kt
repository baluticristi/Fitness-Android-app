package com.example.myapplication
var routinelist = mutableListOf<Routine>()

class Routine(
    var title: String,
    val id: Int? = routinelist.size
        ){
}