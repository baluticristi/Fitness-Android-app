package com.example.myapplication.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the app that I am trying to build... It should keep track of ... Fitness stuff"
    }
    val text: LiveData<String> = _text
}