package com.example.moyen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ReussiteActivity extends AppCompatActivity {

    private TextView moyenneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussite);

        moyenneTextView = findViewById(R.id.moyenne_textview);

        double moyenne = getIntent().getDoubleExtra("moyenne", 0);

        moyenneTextView.setText("Félicitations ! Vous avez réussi avec une moyenne de " + moyenne);
    }
}
