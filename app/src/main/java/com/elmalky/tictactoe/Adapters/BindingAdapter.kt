package com.elmalky.tictactoe.Adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.elmalky.tictactoe.Models.Player
import com.elmalky.tictactoe.Util.GameResult
import com.elmalky.tictactoe.Util.Players
import com.elmalky.tictactoe.Data.DataManager as DM

@BindingAdapter(value = ["finish"])
fun finalResult(view:View,gameStatus:GameResult){
    view as TextView
    if(gameStatus == GameResult.NONE){
        view.visibility = View.INVISIBLE
    }else if(gameStatus == GameResult.WIN){
        view.visibility = View.VISIBLE
    }else if (gameStatus == GameResult.DRAW){
        view.text = "Draw"
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter(value = ["show"])
fun showBtn(view:View,gameStatus: GameResult){
    if (gameStatus != GameResult.NONE)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.INVISIBLE
}