package com.elmalky.tictactoe.Models

import com.elmalky.tictactoe.Util.PlayChars

data class Player(
    val name:String,
    var score:Int,
    val char:PlayChars?
)
