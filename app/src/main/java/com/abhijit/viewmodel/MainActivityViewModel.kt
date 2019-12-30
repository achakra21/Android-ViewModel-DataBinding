package com.abhijit.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel() {

    var scoreTeamA = 1;

    var scoreTeamB = 2

    fun incrementTeamA(){
        scoreTeamA++
    }

    fun incrementTeamB(){
        scoreTeamB++
    }
}