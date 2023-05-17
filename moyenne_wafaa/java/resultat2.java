package com.example.moyennecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class resultat2 extends AppCompatActivity {
    private TextView moyenneNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat2);

        moyenneNull = findViewById(R.id.TextView44);
        float moyene= getIntent().getFloatExtra("moyene",0);
        // affichage

        moyenneNull.setText(String.format(Locale.getDefault(),"%.2f",moyene));
    }
}