package com.example.team01;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewMoyenne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewMoyenne = findViewById(R.id.moyenne_reussite);

        float moyenne = getIntent().getFloatExtra("moyenne", 0);
        textViewMoyenne.setText(String.format(Locale.getDefault(), "%.2f", moyenne));
    }
}