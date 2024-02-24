package com.elmalky.tictactoe.Util

import android.view.View
import android.widget.Button
import com.elmalky.tictactoe.MainViewModel
import com.elmalky.tictactoe.R
import com.elmalky.tictactoe.Data.DataManager as DM
import com.elmalky.tictactoe.Util.GameResult
import com.elmalky.tictactoe.Util.Players

object Solver {
    fun play(view: View, gameStatus: GameResult, activePlayer: Players, vm: MainViewModel){
        view as Button
        if (gameStatus == GameResult.NONE && DM.gameState[view.tag.toString().toInt()] == 0) {
            if (activePlayer == Players.PLAYER1) {
                view.setBackgroundResource(R.drawable.x_background)
                view.text = "X"
                vm.activePlayer.postValue(Players.PLAYER2)
                DM.gameState[view.tag.toString().toInt()] = 1
            } else {
                view.setBackgroundResource(R.drawable.o_background)
                view.text = "O"
                vm.activePlayer.postValue(Players.PLAYER1)
                DM.gameState[view.tag.toString().toInt()] = 2
            }
            for (winPosition in DM.winningPositions) {
                if (DM.gameState[winPosition[0]] == DM.gameState[winPosition[1]]
                    && DM.gameState[winPosition[1]] == DM.gameState[winPosition[2]]
                    && DM.gameState[winPosition[0]] != 0
                ) {
                    if (activePlayer == Players.PLAYER1) {
                        DM.player1.score++
                        vm.player1.postValue(DM.player1)
                        vm.winnerPlayer.postValue(vm.player1)
                    } else {
                        DM.player2.score++
                        vm.player2.postValue(DM.player2)
                        vm.winnerPlayer.postValue(vm.player2)
                    }
                    vm.gameStatus.postValue(GameResult.WIN)
                }
            }
        }
        if (0 !in DM.gameState && gameStatus == GameResult.NONE) {
            vm.gameStatus.postValue(GameResult.DRAW)
        }
    }
}