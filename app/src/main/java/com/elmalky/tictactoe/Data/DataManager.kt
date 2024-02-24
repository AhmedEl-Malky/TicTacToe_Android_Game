package com.elmalky.tictactoe.Data

import com.elmalky.tictactoe.Models.Player
import com.elmalky.tictactoe.Util.PlayChars
import com.elmalky.tictactoe.Util.Players

object DataManager {
    lateinit var player1:Player
    lateinit var player2:Player
    val charMap = mapOf("X" to PlayChars.X , "O" to PlayChars.O)
    var gameState = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var winningPositions: List<List<Int>> = listOf(
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    fun insertPlayer(name1:String ,char1:String , name2:String,char2: String){
        player1 = Player(name1, 0,charMap[char1]?:PlayChars.X)
        player2 = Player(name2, 0,charMap[char2]?:PlayChars.O)
    }
    fun getPlayers():List<Player>{
        return listOf(player1, player2)
    }
}