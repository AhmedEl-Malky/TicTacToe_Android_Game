package com.elmalky.tictactoe

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elmalky.tictactoe.Data.DataManager as DM
import com.elmalky.tictactoe.Models.Player
import com.elmalky.tictactoe.Util.GameResult
import com.elmalky.tictactoe.Util.Players
import com.elmalky.tictactoe.Util.Solver

class MainViewModel : ViewModel() {
    val gameResult = ""
    val _activePLayer = Players.values().random()
    val activePlayer = MutableLiveData<Players>(_activePLayer)
    val gameStatus = MutableLiveData<GameResult>(GameResult.NONE)
    val player1 = MutableLiveData<Player>()
    val player2 = MutableLiveData<Player>()
    val winnerPlayer = MutableLiveData<MutableLiveData<Player>>()

    fun getPlayers() {
        player1.postValue(DM.getPlayers()[0])
        player2.postValue(DM.getPlayers()[1])
    }

    fun play(view: View, gameStatus: GameResult, activePlayer: Players) {
        Solver.play(view, gameStatus, activePlayer ,this)
    }

}