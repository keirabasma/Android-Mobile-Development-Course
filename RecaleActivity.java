package com.example.moyen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class RecaleActivity extends AppCompatActivity {

    private TextView moyenneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recale);

        moyenneTextView = findViewById(R.id.moyenne_textview);

        // Récupérer la moyenne calculée
        double moyenne = getIntent().getDoubleExtra("moyenne", 0);

        // Afficher la moyenne avec un message
        moyenneTextView.setText("Dommage, vous êtes recalé avec une moyenne de " + moyenne);
    }
}
