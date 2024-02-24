package com.elmalky.tictactoe.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.elmalky.tictactoe.Data.DataManager as DM
import com.elmalky.tictactoe.MainViewModel
import com.elmalky.tictactoe.R
import com.elmalky.tictactoe.databinding.ActivityGamePlayersBinding

class GamePlayersActivity : AppCompatActivity() {
    lateinit var binder: ActivityGamePlayersBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_game_players)
        binder.vm = viewModel
        binder.lifecycleOwner = this
        playersCharChoice()
        binder.startGameBtn.setOnClickListener {
            startGame()
        }

    }

    lateinit var player1Char: String
    lateinit var player2Char: String
    private var charState = false
    private fun playersCharChoice() {
        binder.apply {
            player1CharX.setOnClickListener {
                it as Button
                it.setBackgroundResource(R.drawable.x_background)
                player2CharO.setBackgroundResource(R.drawable.o_background)
                player1CharO.setBackgroundResource(R.drawable.play_button_background)
                player2CharX.setBackgroundResource(R.drawable.play_button_background)
                player1Char = "X"
                player2Char = "O"
                charState = true
            }
            player1CharO.setOnClickListener {
                it as Button
                it.setBackgroundResource(R.drawable.o_background)
                player1CharX.setBackgroundResource(R.drawable.play_button_background)
                player2CharO.setBackgroundResource(R.drawable.play_button_background)
                player2CharX.setBackgroundResource(R.drawable.x_background)
                player1Char = "O"
                player2Char = "X"
                charState = true
            }
            player2CharX.setOnClickListener {
                it
                it as Button
                it.setBackgroundResource(R.drawable.x_background)
                player1CharO.setBackgroundResource(R.drawable.o_background)
                player2CharO.setBackgroundResource(R.drawable.play_button_background)
                player1CharX.setBackgroundResource(R.drawable.play_button_background)
                player2Char = "X"
                player1Char = "O"
                charState = true
            }
            player2CharO.setOnClickListener {
                it as Button
                it.setBackgroundResource(R.drawable.o_background)
                player2CharX.setBackgroundResource(R.drawable.play_button_background)
                player1CharX.setBackgroundResource(R.drawable.x_background)
                player1CharO.setBackgroundResource(R.drawable.play_button_background)
                player2Char = "O"
                player1Char = "X"
                charState = true
            }
        }
    }

    private fun startGame() {
        if (binder.player1Name.text.isEmpty() || binder.player2Name.text.isEmpty()) {
            Toast.makeText(this, "Type Your Name", Toast.LENGTH_SHORT).show()
        } else if (!charState) {
            Toast.makeText(this, "Choose Your Char X/O", Toast.LENGTH_SHORT).show()
        } else {
            val player1 = binder.player1Name.text.toString().capitalize()
            val player2 = binder.player2Name.text.toString().capitalize()
            if (player1Char == "X")
                DM.insertPlayer(
                    name1 = player1,
                    char1 = player1Char,
                    name2 = player2,
                    char2 = player2Char
                )
            else
                DM.insertPlayer(
                    name1 = player2,
                    char1 = player2Char,
                    name2 = player1,
                    char2 = player1Char
                )
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}