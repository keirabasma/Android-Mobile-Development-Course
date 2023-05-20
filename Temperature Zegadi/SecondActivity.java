package com.example.convertisseur_temp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        double fahrenheit = getIntent().getDoubleExtra("FAHRENHEIT", 0);
        TextView resultText;
        resultText = findViewById(R.id.resultText);
        resultText.setText("Result: " + fahrenheit + " degrees Fahrenheit");
    }
}
