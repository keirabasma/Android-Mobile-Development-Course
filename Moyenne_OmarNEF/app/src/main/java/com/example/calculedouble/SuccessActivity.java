package com.example.calculedouble;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    private TextView moyenneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Récupération du TextView pour afficher la moyenne
        moyenneTextView = findViewById(R.id.textViewMoyenne);

        // Récupération de la moyenne depuis l'intent
        Intent intent = getIntent();
        double moyenne = getIntent().getDoubleExtra("moyenne", 0);

        // Affichage de la moyenne dans le TextView
        moyenneTextView.setText("Moyenne : " + moyenne);
    }
}
