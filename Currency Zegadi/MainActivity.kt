package com.example.tp3exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currencyText : EditText = findViewById(R.id.currencyText)
        var button : Button = findViewById(R.id.button)
        var type : CompoundButton = findViewById(R.id.switch1)
        var dzdeuro : Boolean = false

        type.setOnClickListener{
            if(dzdeuro){
                dzdeuro = !dzdeuro
                type.setText("To DZD")
            } else {
                dzdeuro = !dzdeuro
                type.setText("To EURO")
            }
        }

        button.setOnClickListener {

            var money : Double = Integer.parseInt(currencyText.text.toString()).toDouble()
            if(dzdeuro) {
                money *= 140.45

                currencyText.setText(money.toString())
            } else {
                money *= 0.0071

                currencyText.setText(money.toString())
            }
        }

    }
}