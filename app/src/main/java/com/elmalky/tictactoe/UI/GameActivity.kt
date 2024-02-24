package com.elmalky.tictactoe.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.elmalky.tictactoe.Data.DataManager as DM
import com.elmalky.tictactoe.R
import com.elmalky.tictactoe.databinding.ActivityGameBinding
import com.elmalky.tictactoe.MainViewModel
import com.elmalky.tictactoe.Util.GameResult
import com.elmalky.tictactoe.Util.Players


class GameActivity : AppCompatActivity() {
    private lateinit var binder: ActivityGameBinding
    val viewModel: MainViewModel by viewModels()
    override fun onDestroy() {
        super.onDestroy()
        playAgain()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this@GameActivity, R.layout.activity_game)
        binder.vm = viewModel
        binder.lifecycleOwner = this
        viewModel.getPlayers()
        startTheGame()
        onClickGameBtns()

    }


    private fun onClickGameBtns(){
        binder.playAgainBtn.setOnClickListener {
            playAgain()
        }
        binder.newGameBtn.setOnClickListener {
            playAgain()
            finish()
        }
    }
    private fun playAgain() {
        DM.gameState = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        for (i in 0 until binder.grid.childCount){
            binder.grid.getChildAt(i).setBackgroundResource(R.drawable.play_button_background)
            (binder.grid.getChildAt(i) as Button).text = ""
            viewModel.gameStatus.postValue(GameResult.NONE)
        }
    }

    private fun startTheGame() {
        if (viewModel._activePLayer == Players.PLAYER1) {
            Toast.makeText(this, "${DM.player1.name} start", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "${DM.player2.name} start", Toast.LENGTH_SHORT).show()
        }
    }
}