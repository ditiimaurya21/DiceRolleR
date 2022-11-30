package com.example.diceroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val obj1= Dice(6)
        val dRoll=obj1.roll()
        val storeImageView: ImageView =findViewById(R.id.imageView)
        val dRes= when (dRoll){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }
        storeImageView.setImageResource(dRes)
        storeImageView.contentDescription=dRoll.toString()
    }
}

class Dice(private val numSides:Int){
    fun roll(): Int {
        return (1..numSides).random()
    }
}